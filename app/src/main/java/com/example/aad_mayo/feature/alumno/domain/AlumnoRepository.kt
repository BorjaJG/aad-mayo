package com.example.aad_mayo.feature.alumno.domain

interface AlumnoRepository {


    abstract suspend fun getAlumnoById(idAlumno: String): Alumno?
}