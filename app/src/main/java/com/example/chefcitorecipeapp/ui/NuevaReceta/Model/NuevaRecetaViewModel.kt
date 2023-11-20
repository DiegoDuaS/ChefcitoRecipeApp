package com.example.chefcitorecipeapp.ui.NuevaReceta.Model

    import android.util.Log
    import androidx.compose.runtime.mutableStateListOf
    import androidx.compose.runtime.snapshots.SnapshotStateList
    import androidx.compose.ui.text.input.TextFieldValue
    import androidx.lifecycle.ViewModel
    import com.example.chefcitorecipeapp.ui.NuevaReceta.View.IngredientesParaPreview
    import com.google.firebase.firestore.FirebaseFirestore

class NuevaRecetaViewModel : ViewModel() {

        var ingredientsState = mutableStateListOf<IngredientesParaPreview>()

    fun saveIngredientsState(ingredientes: List<IngredientesParaPreview>) {
        ingredientsState.clear()
        ingredientsState.addAll(ingredientes)
        }
        fun addRecipeToFirestore(
            name: TextFieldValue,
            postId: TextFieldValue,
            preparationTime: TextFieldValue,
            ingredients: List<IngredientesParaPreview>,
            checkedIngredients: SnapshotStateList<IngredientesParaPreview>,
            pasos: SnapshotStateList<String>,
            imageUrl: String
        ) {
            // Convert steps list to a single string separated by "$"
            val stepsString = pasos.joinToString(separator = "$")

            // Create a map of ingredients with their checked states
            val ingredientsMap = ingredients.associate { ingredient ->
                ingredient.name to checkedIngredients.contains(ingredient)
            }

            val recipeMap = hashMapOf(
                "Nombre_Receta" to name.text,
                "Post_id" to postId.text,
                "Preparation_Time" to preparationTime.text,
                "Ingredients" to ingredientsMap,
                "Pasos" to stepsString,
                "ImageUrl" to imageUrl
            )

            // Add to Firestore
            FirebaseFirestore.getInstance().collection("posts").add(recipeMap)
                .addOnSuccessListener { documentReference ->
                    Log.d("SuccesBase","Creado Post")
                }
                .addOnFailureListener { e ->
                    Log.d("Fail","Error Creando Post")
                }
        }



    }