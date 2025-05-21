package com.example.aad_mayo.core.data.remote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_mayo.feature.alumno.data.remote.AlumnoDao
import com.example.aad_mayo.feature.alumno.data.remote.EntityAlumno

@Database(entities = [EntityAlumno.User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): AlumnoDao

}
val applicationContext: Context
    get() {
        TODO()
    }
val db = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "database-name"
).build()


