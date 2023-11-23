package com.example.chefcitorecipeapp.ui.PantallaPrincipal.Model
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.Recipe
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class PantallaPrincipalScreenViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    private val _documentIds = MutableLiveData<List<String>>()
    private val _recipes = MutableLiveData<List<Recipe>>()

    private val _selectedRecipe = MutableLiveData<Recipe?>()
    val selectedRecipe: LiveData<Recipe?> = _selectedRecipe

    val recipes: LiveData<List<Recipe>> = _recipes

    init {
        loadDocumentIds()
    }

    fun loadDocumentIds() {
        encontrarIdsConCoincidencias { matchedIds ->
            _documentIds.postValue(matchedIds)
            loadRecipesByIds(matchedIds)
        }
    }

    fun encontrarIdsConCoincidencias(onIdsFound: (List<String>) -> Unit) {
        val matchedDocumentIds = mutableListOf<String>()

        firestore.collection("posts").get()
            .addOnSuccessListener { snapshot ->
                for (document in snapshot.documents) {
                    val fieldsToCheck = listOf("Pollo", "Carne_Molida", "Pasta", "Arroz",
                        "Harina", "Papa", "Cebolla", "Ajo",
                        "Sal", "Pimienta", "Huevos", "Leche")

                    val isMatchFound = fieldsToCheck.any { fieldName ->
                        val documentValue = document.getBoolean(fieldName) ?: false
                        val singletonValue = when(fieldName) {
                            "Pollo" -> MySingleton.Pollo
                            "Carne_Molida" -> MySingleton.Carne_Molida
                            "Pasta" -> MySingleton.Pasta
                            "Arroz" -> MySingleton.Arroz
                            "Harina" -> MySingleton.Harina
                            "Papa" -> MySingleton.Papa
                            "Cebolla" -> MySingleton.Cebolla
                            "Ajo" -> MySingleton.Ajo
                            "Sal" -> MySingleton.Sal
                            "Pimienta" -> MySingleton.Pimienta
                            "Huevos" -> MySingleton.Huevos
                            "Leche" -> MySingleton.Leche
                            else -> false
                        }
                        documentValue && singletonValue
                    }

                    if (isMatchFound) {
                        matchedDocumentIds.add(document.id)

                    }
                }
                onIdsFound(matchedDocumentIds)
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
                onIdsFound(listOf())
            }
    }







    private fun loadRecipesByIds(documentIds: List<String>) {
        val recipesList = mutableListOf<Recipe>()

        val tasks = documentIds.map { documentId ->
            firestore.collection("posts").document(documentId).get()
        }

        Tasks.whenAllSuccess<DocumentSnapshot>(tasks).addOnSuccessListener { documents ->
            documents.forEach { document ->
                val recipe = Recipe(
                    Ajo = document.getBoolean("Ajo") ?: false,
                    Arroz = document.getBoolean("Arroz") ?: false,
                    Carne_Molida = document.getBoolean("Carne_Molida") ?: false,
                    Cebolla = document.getBoolean("Cebolla") ?: false,
                    Harina = document.getBoolean("Harina") ?: false,
                    Huevos = document.getBoolean("Huevos") ?: false,
                    ImageUrl = document.getString("ImageUrl") ?: "",
                    Leche = document.getBoolean("Leche") ?: false,
                    Nombre_Receta = document.getString("Nombre_Receta") ?: "",
                    Papa = document.getBoolean("Papa") ?: false,
                    Pasos = document.getString("Pasos") ?: "",
                    Pasta = document.getBoolean("Pasta") ?: false,
                    Pimienta = document.getBoolean("Pimienta") ?: false,
                    Pollo = document.getBoolean("Pollo") ?: false,
                    Post_id = document.id,
                    Preparation_Time = document.getString("Preparation_Time") ?: "",
                    Sal = document.getBoolean("Sal") ?: false,
                    Nombre_de_chef = document.getString("Nombre_de_chef") ?: ""
                )
                recipesList.add(recipe)
            }
            _recipes.postValue(recipesList)
        }
    }

}
