package com.example.aad_mayo.feature.alumno.data.remote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlumnoDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<EntityAlumno.User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: String): List<EntityAlumno.User>

    @Query("SELECT * FROM user WHERE name LIKE :first AND " +
            "apellido LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): EntityAlumno.User

    @Insert
    fun insertAll(vararg users: EntityAlumno.User)

    @Delete
    fun delete(user: EntityAlumno.User)
}