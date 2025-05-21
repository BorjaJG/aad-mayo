package com.example.aad_mayo.feature.alumno.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.aad_mayo.R
import com.example.aad_mayo.feature.alumno.domain.Alumno
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader

class AlumnoSharedPreferencesDataSource(
    private val context: Context,
    private val sharedPreferences: SharedPreferences
) {

    private val json = Json { prettyPrint = true; ignoreUnknownKeys = true }

    suspend fun getAlumnoById(id: String): Alumno? {
        val alumnoJson = sharedPreferences.getString(id, null)

        if (alumnoJson == null) {
            Log.d("AlumnoSP", "No se encontró alumno con id: $id")
            loadAlumnosFromRawIfNeeded(R.raw.alumnos)
            return sharedPreferences.getString(id, null)?.let {
                json.decodeFromString<Alumno>(it)
            }
        }

        Log.d("AlumnoSP", "JSON recuperado: $alumnoJson")
        return json.decodeFromString<Alumno>(alumnoJson)
    }

    suspend fun saveAlumno(alumno: Any) {
        val alumnoJson = json.encodeToString(alumno)
        sharedPreferences.edit().putString(alumno.toString(), alumnoJson).apply()
        Log.d("AlumnoSP", "Alumno guardado: $alumnoJson")
    }

    suspend fun loadAlumnosFromRawIfNeeded(rawResId: Int) {
        try {
            val inputStream = context.resources.openRawResource(rawResId)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val content = reader.use { it.readText() }

            val alumnos: List<Alumno> = json.decodeFromString(content)
            val editor = sharedPreferences.edit()
            for (alumno in alumnos) {
                val alumnoJson = json.encodeToString(alumno)
                editor.putString(alumno.id, alumnoJson)
            }
            editor.apply()
            Log.d("AlumnoSP", "Alumnos cargados desde raw")

        } catch (e: Exception) {
            Log.e("AlumnoSP", "Error cargando JSON de raw", e)
        }
    }

}
