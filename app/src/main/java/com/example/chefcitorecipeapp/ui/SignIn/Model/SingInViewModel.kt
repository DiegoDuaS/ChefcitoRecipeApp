package com.example.chefcitorecipeapp.ui.SignIn.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.*
import com.google.firebase.firestore.FirebaseFirestore

class SingInViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun CreateUserWithEmailAndPassword(
        email:String,
        password:String,
        home: () -> Unit
    ){
        if(_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        val displayName = task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        home()
                    }
                    else{
                        Log.d("Fail","RegisterWithEmailAndPassword:  ${task.result.toString()}")

                    }
                    _loading.value = false
                }


        }

    }

    private fun createUser(displayName: String?) {
        val userid = auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()

        user["user_id"] = userid.toString()
        user["display_name"] = displayName.toString()
        user["Document_ID"] = ""
        user["Pollo"] = false
        user["Carne_Molida"] = false
        user["Pasta"] = false
        user["Arroz"] = false
        user["Harina"] = false
        user["Papa"] = false
        user["Cebolla"] = false
        user["Tomate"] = false
        user["Ajo"] = false
        user["Sal"] = false
        user["Pimienta"] = false
        user["Huevos"] = false
        user["Leche"] = false

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("SuccesBase","Creado  ${it.id}")
            }.addOnFailureListener{
                Log.d("FailBase","Ocurrio error  ${it}")
            }




    }


}