package com.bassamkhafagy.hafez.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassamkhafagy.hafez.data.local.ImportedData
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.data.local.Student
import com.bassamkhafagy.hafez.fragments.showallstudent.compose.StudentUIState
import com.bassamkhafagy.hafez.repositories.HafezRepository
import com.bassamkhafagy.hafez.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HafezViewModel @Inject constructor(private val repository: HafezRepository) : ViewModel() {

    //all data show
    private val _studentsUiState: MutableState<StudentUIState> =
        mutableStateOf(
            StudentUIState.Loading
        )
    val studentsUiState: State<StudentUIState> = _studentsUiState


    //uiInterAction
    private val _uiStateLiveDate = MutableLiveData<Resource<String>>()
    val uiStateLiveDate: LiveData<Resource<String>> = _uiStateLiveDate

    //setNameByCode
    private val _studentNameLiveDate = MutableLiveData<String>()
    val studentNameLiveDate: LiveData<String> = _studentNameLiveDate

    //setAllDataInShowByCode
    private val _studentLiveDate = MutableLiveData<Student>()
    val studentLiveDate: LiveData<Student> = _studentLiveDate


    //<-- Dialogs Live Data
    private val _sheikhLiveDate = MutableLiveData<String>()
    val sheikhLiveDate: LiveData<String> = _sheikhLiveDate

    private val _surahLiveDate = MutableLiveData<String>()
    val surahLiveDate: LiveData<String> = _surahLiveDate

    private val _passedStateLiveDate = MutableLiveData<String>()
    val passedStateLiveData: LiveData<String> = _passedStateLiveDate
    //-->

    fun setSheikhName(sheikh: String) {
        viewModelScope.launch {
            _sheikhLiveDate.value = sheikh
        }
    }

    fun setSurahName(surah: String) {
        viewModelScope.launch {
            _surahLiveDate.value = surah
        }
    }

    fun setStateValue(state: String) {
        viewModelScope.launch {
            _passedStateLiveDate.value = state
        }
    }

    fun setStudentName(state: String) {
        viewModelScope.launch {
            _studentNameLiveDate.value = state
        }
    }

    fun setUiState(state: Resource<String>) {
        _uiStateLiveDate.postValue(state)
    }


    suspend fun insertAllImportedDate(importedData: List<ImportedData>) {
        repository.insertAllImportedData(importedData)
    }

    suspend fun clearAllImportedData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearImportedDataTable()
        }
    }

    suspend fun getAllSheikhData() =
        repository.getAllSheikhData()


    suspend fun checkIFStudentExist(studentCode: Long) =
        repository.checkIFStudentExist(studentCode)


    suspend fun getStudentNameByCode(studentCode: Long) =
        repository.getStudentNameByCode(studentCode)

    suspend fun getStudentDataByCode(studentCode: Long) {
        _studentLiveDate.postValue(repository.getStudentDataByCode(studentCode))
    }

    suspend fun getAllSoraReviews() = repository.getAllReviews()

    suspend fun saveReview(soraReview: SoraReview) {
        _uiStateLiveDate.postValue(Resource.Loading())

        if (repository.insertSoraReview(soraReview) > 0) {
            _uiStateLiveDate.postValue(Resource.Success(""))

        } else _uiStateLiveDate.postValue(Resource.Error(""))

    }

    suspend fun getAllStudent() {
        _studentsUiState.value = StudentUIState.Success(repository.getAllStudentData())
    }
}

