package com.example.chefcitorecipeapp.ui.Receta.Model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chefcitorecipeapp.ui.Receta.View.RecipeParameters
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlin.reflect.full.memberProperties

class RecetaViewModel: ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _recipeParameters = MutableLiveData<RecipeParameters>()
    val recipeParameters: LiveData<RecipeParameters> = _recipeParameters


    fun getRecipeParameters(documentId: String) {
        viewModelScope.launch {
            try {
                val documentSnapshot = db.collection("posts").document(documentId).get().await()
                val recipeParameters = documentSnapshot.toObject(RecipeParameters::class.java)
                _recipeParameters.postValue(recipeParameters) // Post the result to LiveData
            } catch (e: Exception) {
                _recipeParameters.postValue(null)
            }
        }
    }
    fun getTrueIngredients(localCopy: RecipeParameters): List<String> {
        return RecipeParameters::class.memberProperties
            .filter { it.returnType.classifier == Boolean::class && it.get(localCopy) == true }
            .map { it.name }
    }



}