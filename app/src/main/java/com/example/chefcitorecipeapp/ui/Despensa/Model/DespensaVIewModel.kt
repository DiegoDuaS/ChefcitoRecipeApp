package com.example.chefcitorecipeapp.ui.Despensa.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chefcitorecipeapp.ui.FirebaseData.MySingleton
import com.google.firebase.firestore.FirebaseFirestore

class DespensaVIewModel: ViewModel() {
    val polloState = MutableLiveData(MySingleton.Pollo)
    val MolidaState = MutableLiveData(MySingleton.Carne_Molida)
    val PastaState = MutableLiveData(MySingleton.Pasta)
    val ArrozState = MutableLiveData(MySingleton.Arroz)
    val HarinaState = MutableLiveData(MySingleton.Harina)
    val PapaState = MutableLiveData(MySingleton.Papa)
    val CebollaState = MutableLiveData(MySingleton.Cebolla)
    val AjoState = MutableLiveData(MySingleton.Ajo)
    val SalState = MutableLiveData(MySingleton.Sal)
    val PimientaState = MutableLiveData(MySingleton.Pimienta)
    val HuevosState = MutableLiveData(MySingleton.Huevos)
    val LecheState = MutableLiveData(MySingleton.Leche)

    fun updateFirestoreDocument() {
        // Get the Firestore instance
        val db = FirebaseFirestore.getInstance()

        // Create a map of values to update
        val updates = hashMapOf<String, Any>(
            "Ajo" to MySingleton.Ajo,
            "Arroz" to MySingleton.Arroz,
            "Carne_Molida" to MySingleton.Carne_Molida,
            "Cebolla" to MySingleton.Cebolla,
            "Harina" to MySingleton.Harina,
            "Huevos" to MySingleton.Huevos,
            "Leche" to MySingleton.Leche,
            "Papa" to MySingleton.Papa,
            "Pasta" to MySingleton.Pasta,
            "Pimienta" to MySingleton.Pimienta,
            "Pollo" to MySingleton.Pollo,
            "Sal" to MySingleton.Sal,
        )

        // Update the document in the 'users' collection
        MySingleton.documentID?.let { documentId ->
            db.collection("users").document(documentId).update(updates)
                .addOnSuccessListener {
                    Log.d("Success", " Se actualizo la nube")
                }
                .addOnFailureListener { e ->
                    Log.d("Fail", "No se actualizo la nube ")
                }
        }
    }






        // Function to update Pollo state
        fun updatePollo(isChecked: Boolean) {
            MySingleton.Pollo = isChecked
            polloState.value = isChecked
        }

        // Function to update Carne Molida state
        fun updateCarneMolida(isChecked: Boolean) {
            MySingleton.Carne_Molida = isChecked
            MolidaState.value = isChecked
        }

        // Function to update Pasta state
        fun updatePasta(isChecked: Boolean) {
            MySingleton.Pasta = isChecked
            PastaState.value = isChecked
        }

        // Function to update Arroz state
        fun updateArroz(isChecked: Boolean) {
            MySingleton.Arroz = isChecked
            ArrozState.value = isChecked
        }

        // Function to update Harina state
        fun updateHarina(isChecked: Boolean) {
            MySingleton.Harina = isChecked
            HarinaState.value = isChecked
        }

        // Function to update Papa state
        fun updatePapa(isChecked: Boolean) {
            MySingleton.Papa = isChecked
            PapaState.value = isChecked
        }

        // Function to update Cebolla state
        fun updateCebolla(isChecked: Boolean) {
            MySingleton.Cebolla = isChecked
            CebollaState.value = isChecked
        }

        // Function to update Ajo state
        fun updateAjo(isChecked: Boolean) {
            MySingleton.Ajo = isChecked
            AjoState.value = isChecked
        }

        // Function to update Sal state
        fun updateSal(isChecked: Boolean) {
            MySingleton.Sal = isChecked
            SalState.value = isChecked
        }

        // Function to update Pimienta state
        fun updatePimienta(isChecked: Boolean) {
            MySingleton.Pimienta = isChecked
            PimientaState.value = isChecked
        }

        // Function to update Huevos state
        fun updateHuevos(isChecked: Boolean) {
            MySingleton.Huevos = isChecked
            HuevosState.value = isChecked
        }

        // Function to update Leche state
        fun updateLeche(isChecked: Boolean) {
            MySingleton.Leche = isChecked
            LecheState.value = isChecked
        }



}