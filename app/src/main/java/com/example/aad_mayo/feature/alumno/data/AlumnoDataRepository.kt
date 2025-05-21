package com.example.aad_mayo.feature.alumno.data



import com.example.aad_mayo.feature.alumno.data.remote.AlumnoDataRepositoryRemote
import com.example.aad_mayo.feature.alumno.domain.Alumno
import com.example.aad_mayo.feature.alumno.domain.AlumnoRepository

class AlumnoDataRepository(
    private val localDataSource: AlumnoSharedPreferencesDataSource,
    private val remoteDataSource: AlumnoDataRepositoryRemote
) : AlumnoRepository {

    override suspend fun getAlumnoById(idAlumno: String): Alumno? {

        val localResult = localDataSource.getAlumnoById(idAlumno)
        if (localResult != null) {
            return localResult
        }


        val remoteResult = remoteDataSource.getAlumnoById(idAlumno)


        remoteResult?.let {
            localDataSource.saveAlumno(it)
        }

        return remoteResult
    }
}
