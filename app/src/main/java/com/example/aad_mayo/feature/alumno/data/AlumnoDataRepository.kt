package com.example.aad_mayo.feature.alumno.data


import com.example.aad_mayo.feature.alumno.domain.Alumno
import com.example.aad_mayo.feature.alumno.domain.AlumnoRepository

class AlumnoDataRepository(
    private val localDataSource: AlumnoSharedPreferencesDataSource
) : AlumnoRepository {
    override suspend fun getAlumnoById(id: String): Alumno? {
        return localDataSource.getAlumnoById(id)
    }
}
