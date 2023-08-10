package com.bassamkhafagy.hafez.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassamkhafagy.hafez.data.local.ReviewComplete
import com.bassamkhafagy.hafez.data.local.Sheikh
import com.bassamkhafagy.hafez.data.local.Students
import com.bassamkhafagy.hafez.repositories.HafezRepository
import com.bassamkhafagy.hafez.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HafezViewModel @Inject constructor(private val repository: HafezRepository) : ViewModel() {

    private val _uiStateLiveDate = MutableLiveData<Resource<String>>()
    val uiStateLiveDate: LiveData<Resource<String>> = _uiStateLiveDate

    private val _sheikhLiveDate = MutableLiveData<String>()
    val sheikhLiveDate: LiveData<String> = _sheikhLiveDate

    private val _sheikhListLiveDate = MutableLiveData<List<Sheikh>>()
    val sheikhListLiveDate: LiveData<List<Sheikh>> = _sheikhListLiveDate

    private val _surahLiveDate = MutableLiveData<String>()
    val surahLiveDate: LiveData<String> = _surahLiveDate

    private val _stateLiveDate = MutableLiveData<String>()
    val stateLiveDate: LiveData<String> = _stateLiveDate

    private val _studentLiveDate = MutableLiveData<Students>()
    val studentLiveDate: LiveData<Students> = _studentLiveDate

    private val _shuyukhLiveDate = MutableLiveData<Sheikh>()
    val shuyukhLiveDate: LiveData<Sheikh> = _shuyukhLiveDate

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
            _stateLiveDate.value = state
        }
    }

    fun insertAllStudents(studentsList: List<Students>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllStudent(studentsList)
        }
    }

    fun insertAllSheikh(sheikhList: List<Sheikh>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllSheikh(sheikhList)
        }
    }

    suspend fun getStudentByCode(studentCode: Int) {
        _studentLiveDate.postValue(repository.getStudentById(studentCode))
    }

    suspend fun checkIfStudentInTable(studentCode: Int): Int {
        return repository.checkIfStudentIsInTable(studentCode)
    }


    suspend fun insertReview(reviewComplete: ReviewComplete) {
        repository.insertSoraReview(reviewComplete)
    }

    suspend fun getAllSorReview() = repository.getAllSorReview()


}

