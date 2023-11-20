package com.example.chefcitorecipeapp.ui.PantallaInicio.Model


import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class PantallaInicioViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth


    fun signInWithEmailAndPassword(email: String, password: String, home: (Boolean) -> Unit) = viewModelScope.launch {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Success", "signInWithEmailAndPassword logged in!!!")

                    // These are now non-nullable Strings with the not-null assertion operator.
                    val userid = auth.currentUser?.uid
                    val Correo: String? = auth.currentUser!!.email
                   val Usuario = Correo!!.split("@").get(0)

                    MySingleton.userID = userid
                    MySingleton.DisplayName = Usuario

                    home(true) // Sign-in was successful, call home with true.
                } else {
                    Log.d("Fail", "signInWithEmailAndPassword failed: ${task.exception?.message}")
                    home(false) // Sign-in failed, call home with false.
                }
            }
    }


    fun EncontrarIdDelDocumento(userIdToCompare: String?, onDocumentIdFound: (String) -> Unit) {
        val firestore = FirebaseFirestore.getInstance()

        firestore.collection("users").get()
            .addOnSuccessListener { snapshot ->
                for (document in snapshot.documents) {
                    val userId = document.getString("user_id")
                    if (userIdToCompare == userId) {
                        MySingleton.documentID = document.id
                        onDocumentIdFound(document.id) // Invoke the callback with the found document ID
                        return@addOnSuccessListener
                    }
                }
                onDocumentIdFound("") // Invoke the callback with empty string if not found
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
                onDocumentIdFound("") // Invoke the callback with empty string on failure
            }
    }



    fun ObtenerParametrosDelDocumento(documentId: String) = viewModelScope.launch {
        val documentReference = FirebaseFirestore.getInstance().collection("users").document(documentId)

        documentReference.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                documentSnapshot.getString("user_id")?.let { MySingleton.userID = it }
                documentSnapshot.getBoolean("Pollo")?.let { MySingleton.Pollo = it }
                documentSnapshot.getBoolean("Carne_Molida")?.let { MySingleton.Carne_Molida = it }
                documentSnapshot.getBoolean("Pasta")?.let { MySingleton.Pasta = it }
                documentSnapshot.getBoolean("Arroz")?.let { MySingleton.Arroz = it }
                documentSnapshot.getBoolean("Harina")?.let { MySingleton.Harina = it }
                documentSnapshot.getBoolean("Papa")?.let { MySingleton.Papa = it }
                documentSnapshot.getBoolean("Cebolla")?.let { MySingleton.Cebolla = it }
                documentSnapshot.getBoolean("Tomate")?.let { MySingleton.Tomate = it }
                documentSnapshot.getBoolean("Ajo")?.let { MySingleton.Ajo = it }
                documentSnapshot.getBoolean("Sal")?.let { MySingleton.Sal = it }
                documentSnapshot.getBoolean("Pimienta")?.let { MySingleton.Pimienta = it }
                documentSnapshot.getBoolean("Huevos")?.let { MySingleton.Huevos = it }
                documentSnapshot.getBoolean("Leche")?.let { MySingleton.Leche = it }
            }
        }.addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
        }
    }








}