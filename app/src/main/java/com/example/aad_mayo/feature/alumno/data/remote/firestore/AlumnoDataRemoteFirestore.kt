package com.example.aad_mayo.feature.alumno.data.remote.firestore

import android.util.Log
import com.example.aad_mayo.core.data.remote.db
import com.example.aad_mayo.feature.alumno.data.remote.room.EntityAlumno
import com.example.aad_mayo.feature.alumno.domain.Alumno
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AlumnoDataRemoteFirestore {
    
    
    private lateinit var auth: FirebaseAuth
    fun getAlumnoById(idAlumno: String): Alumno {


        val db = FirebaseFirestore.getInstance()
        val coleccion = db.collection("ClaseA")

        val objeto = hashMapOf(
            "1" to "valorA",
            "atributoB" to 123
        )

        coleccion.add(objeto)
            .addOnSuccessListener { documentRef ->
                Log.d("Firestore", "Documento añadido con ID: ${documentRef.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error al añadir documento", e)
            }

        return getAlumnoById(idAlumno.toString())
    }



   




}