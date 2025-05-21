package com.example.aad_mayo.feature.alumno.domain

class GetAlumnoUseCase ( private val alumnoRepository: AlumnoRepository){
    suspend operator fun invoke(idAlumno: String): Alumno? {
        return alumnoRepository.getAlumnoById(idAlumno)
    }

}