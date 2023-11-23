package com.example.chefcitorecipeapp.ui.NuevaReceta.Model

    import android.util.Log
    import androidx.compose.runtime.mutableStateListOf
    import androidx.compose.runtime.snapshots.SnapshotStateList
    import androidx.compose.ui.text.input.TextFieldValue
    import androidx.lifecycle.ViewModel
    import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
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
        checkedIngredients: SnapshotStateList<IngredientesParaPreview>,
        pasos: SnapshotStateList<String>,
        imageUrl: String
    ) {
        val stepsString = pasos.joinToString(separator = "$")

        val ingredientNames = listOf(
            "Pollo", "Carne_Molida", "Pasta", "Arroz", "Harina", "Papa",
            "Cebolla", "Ajo", "Sal", "Pimienta", "Huevos", "Leche"
        )
        val ingredientBooleans = ingredientNames.associateWith { false }.toMutableMap()

        checkedIngredients.forEach { checkedIngredient ->
            ingredientBooleans[checkedIngredient.name] = true
        }

        val recipeMap = hashMapOf<String, Any>(
            "Nombre_de_chef" to MySingleton.DisplayName,
            "Nombre_Receta" to name.text,
            "Post_id" to postId.text,
            "Preparation_Time" to preparationTime.text,
            "Pasos" to stepsString,
            "ImageUrl" to imageUrl
        ) + ingredientBooleans

        FirebaseFirestore.getInstance().collection("posts").add(recipeMap)
            .addOnSuccessListener { documentReference ->
                Log.d("SuccessBase","Creado Post")
            }
            .addOnFailureListener { e ->
                Log.d("Fail","Error Creando Post", e)
            }
    }

}