package com.example.chefcitorecipeapp.ui.PantallaPrincipal.Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.RecetasParaPreview
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlin.reflect.full.memberProperties

class PantallaPrincipalScreenViewModel: ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    fun fetchMatchingPosts() {
        db.collection("posts").get().addOnSuccessListener { documents ->
            val matchingPosts = documents.mapNotNull { document ->
                val ingredients = document.data["ingredients"] as? Map<String, Boolean>
                if (ingredients != null && ingredientsMatchWithSingleton(ingredients)) {
                    document.toObject(Post::class.java).let { post ->
                        post.copy(
                            Preparation_Time = post.Preparation_Time?.toString()
                        )
                    }
                } else {
                    null
                }
            }
            _postsLiveData.value = matchingPosts
        }.addOnFailureListener {
        }
    }

    private fun ingredientsMatchWithSingleton(ingredients: Map<String, Boolean>): Boolean {
        val singleton = MySingleton // Use your actual singleton's instance

        if (ingredients["Pollo"] == true && singleton.Pollo) return true
        if (ingredients["Carne_Molida"] == true && singleton.Carne_Molida) return true
        if (ingredients["Pasta"] == true && singleton.Pasta) return true
        if (ingredients["Arroz"] == true && singleton.Arroz) return true
        if (ingredients["Harina"] == true && singleton.Harina) return true
        if (ingredients["Papa"] == true && singleton.Papa) return true
        if (ingredients["Cebolla"] == true && singleton.Cebolla) return true
        if (ingredients["Tomate"] == true && singleton.Tomate) return true
        if (ingredients["Ajo"] == true && singleton.Ajo) return true
        if (ingredients["Sal"] == true && singleton.Sal) return true
        if (ingredients["Pimienta"] == true && singleton.Pimienta) return true
        if (ingredients["Huevos"] == true && singleton.Huevos) return true
        if (ingredients["Leche"] == true && singleton.Leche) return true

        return false
    }

}

    data class Post(
        val Nombre_Receta: String? = null,
        val Post_id: String? = null,
        val Preparation_Time: String? = null,
        val Pasos: String? = null,
        val ImageUrl: String? = null,
        val ingredients: Map<String, Boolean>? = null
    )

