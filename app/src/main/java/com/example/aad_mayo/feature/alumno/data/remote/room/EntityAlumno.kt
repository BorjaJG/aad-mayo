package com.example.aad_mayo.feature.alumno.data.remote.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class EntityAlumno {

    @Entity
    data class User(
        @PrimaryKey val id: String?,
        @ColumnInfo(name = "name") val name: String?,
        @ColumnInfo(name = "apellido") val apellido: String?,
        @ColumnInfo(name = "listAsignatura") val listAsignatura: List<Asignatura>?,
        @ColumnInfo(name = "idGrupo") val idGrupo: String?,
        @ColumnInfo(name = "grupo") val grupo: String?,
        @ColumnInfo(name = "idCurso") val idCurso: String?,
        @ColumnInfo(name = "curso") val curso: String?,
        @ColumnInfo(name = "idMatricula") val idMatricula: String?,
        @ColumnInfo(name = "fechaMatriculacion") val fechaMatriculacion: String?,
        @ColumnInfo(name = "fechaNacimiento") val fechaNacimiento: String?


        )
    @Entity
    data class Asignatura(
        @PrimaryKey val idAsignatura: String?,
        @ColumnInfo(name = "asignatura") val apellido: String?,
        @ColumnInfo(name = "nota") val name: String?)

}