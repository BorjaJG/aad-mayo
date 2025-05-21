package com.example.aad_mayo.feature.alumno.domain

import kotlinx.serialization.Serializable


@Serializable
data class Alumno(
    val id: String,
    val name: String,
    val apellido: String,
    val listAsignatura: List<Asignatura>,
    val idGrupo: String,
    val grupo: String,
    val idCurso: String,
    val curso: String,
    val idMatricula: String,
    val fechaMatriculacion: String,
    val fechaNacimiento: String
)
@Serializable
data class Asignatura(
    val idAsignatura: String,
    val asignatura: String,
    val nota: String
)
