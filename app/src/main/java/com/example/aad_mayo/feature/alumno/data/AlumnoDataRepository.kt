package com.example.aad_mayo.feature.alumno.data



import com.example.aad_mayo.feature.alumno.data.remote.firestore.AlumnoDataRemoteFirestore
import com.example.aad_mayo.feature.alumno.data.remote.room.AlumnoDataRepositoryRemote
import com.example.aad_mayo.feature.alumno.domain.Alumno



class ClaseARepository(
    private val sharedPreferencesDataSource: AlumnoDataRepositoryRemote,
    private val firestoreDataSource: AlumnoDataRemoteFirestore,
    private val roomDataSource: AlumnoDataRepositoryRemote
) {

    suspend fun getElementoById(id: String): String? {
        // Intentar obtener de SharedPreferences
        sharedPreferencesDataSource.getAlumnoById(id)?.let {
            return it.toString()
        }

        // Si no está en SharedPreferences, buscar en Firestore
        firestoreDataSource.getAlumnoById(id)?.let { elemento ->
            // Guardar en local si se desea
            sharedPreferencesDataSource.saveElemento(elemento)
            return elemento
        }

        // Si no está en Firestore, buscar en Room
        return roomDataSource.getAlumnoById(id)
    }
}
