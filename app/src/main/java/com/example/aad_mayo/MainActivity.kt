package com.example.aad_mayo


import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aad_mayo.feature.alumno.data.AlumnoSharedPreferencesDataSource
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("alumnos_prefs", Context.MODE_PRIVATE)
        val dataSource = AlumnoSharedPreferencesDataSource(this, prefs)

        lifecycleScope.launch {
            dataSource.loadAlumnosFromRawIfNeeded(R.raw.alumnos)
        }
    }
}
