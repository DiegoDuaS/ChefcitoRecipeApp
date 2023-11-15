package com.example.chefcitorecipeapp.ui.PantallaInicio.Model


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class PantallaInicioViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)


    fun signInWithEmailAndPassword(email: String, password: String, home: ()-> Unit)
            = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Log.d("MascotaFeliz","signinWithEmailAndPassword loguado!!!")
                        home()
                    }
                    else{
                        Log.d("MascotaFeliz","signinWithEmailAndPassword:  ${task.result.toString()}")
                    }
                }
        }
        catch (ex: Exception){
            Log.d("MascotaFeliz","signinWithEmailAndPassword: ${ex.message}")


        }


    }
}