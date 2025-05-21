package com.example.aad_mayo.feature.alumno.data.remote.room

import android.content.Context
import androidx.room.RoomDatabase
import com.example.aad_mayo.core.data.remote.db
import com.example.aad_mayo.feature.alumno.domain.Alumno

class AlumnoDataRepositoryRemote (
    private val context: Context,
    private val roomDatabase: RoomDatabase){


    suspend fun getAlumnoById(id: String): Alumno {
        val userDao = db.userDao()
        val id: List<EntityAlumno.User> = userDao.loadAllByIds(userIds = id)
        return getAlumnoById(id.toString())
    }




}