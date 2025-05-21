package com.example.aad_mayo.feature.alumno.data



import com.example.aad_mayo.feature.alumno.data.remote.firestore.AlumnoDataRemoteFirestore
import com.example.aad_mayo.feature.alumno.data.remote.room.AlumnoDataRepositoryRemote
import com.example.aad_mayo.feature.alumno.domain.Alumno
import com.example.aad_mayo.feature.alumno.domain.AlumnoRepository

class AlumnoDataRepository(
    private val localDataSource: AlumnoSharedPreferencesDataSource,
    private val remoteDataSource: AlumnoDataRepositoryRemote,
    private  val remotefiresDataSource: AlumnoDataRemoteFirestore
) : AlumnoRepository {

    override suspend fun getAlumnoById(idAlumno: String): Alumno? {

        val localResult = localDataSource.getAlumnoById(idAlumno)
        if (localResult != null) {
            return localResult
        }else{
            val remoteResult = remoteDataSource.getAlumnoById(idAlumno)
            if(remoteResult != null){

                remoteResult?.let {
                    localDataSource.saveAlumno(it)
                }
                return remoteResult
            }
            else{
                val remoteResultfires = remotefiresDataSource.getAlumnoById(idAlumno)
                remoteResultfires?.let {
                    localDataSource.saveAlumno(it)
                }
                return remoteResultfires

            }


        }





    }
}
