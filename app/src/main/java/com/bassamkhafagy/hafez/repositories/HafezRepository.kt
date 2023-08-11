package com.bassamkhafagy.hafez.repositories

import com.bassamkhafagy.hafez.data.database.HafezAppDataBase
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.data.local.ImportedData
import javax.inject.Inject

class HafezRepository @Inject constructor(private val hafezAppDataBase: HafezAppDataBase) {

    ///ImportedMethods
    suspend fun insertAllImportedData(importedData: List<ImportedData>) {
        hafezAppDataBase.importedStudentsDao().insertAllImportedData(importedData)
    }

    suspend fun checkIFStudentExist(studentCode: Long) =
        hafezAppDataBase.importedStudentsDao().checkIfIdExists(studentCode)


    suspend fun getAllSheikhData() =
        hafezAppDataBase.importedStudentsDao().getAllShuyukh()


    suspend fun getStudentByCode(studentCode: Long) =
        hafezAppDataBase.importedStudentsDao().getStudentByCode(studentCode)


    suspend fun clearImportedDataTable() = hafezAppDataBase.importedStudentsDao().clearTable()


    ///ReviewMethods
    suspend fun insertSoraReview(soraReview: SoraReview) =
        hafezAppDataBase.soraReviewDao().insertSoraReview(soraReview)


    suspend fun clearSoraREviewsDataTable() = hafezAppDataBase.soraReviewDao().clearTable()

    suspend fun getAllReviews() =
        hafezAppDataBase.soraReviewDao().getAllSorReview()


}