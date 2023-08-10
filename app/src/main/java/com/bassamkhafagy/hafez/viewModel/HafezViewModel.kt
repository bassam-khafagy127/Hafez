package com.bassamkhafagy.hafez.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassamkhafagy.hafez.data.local.Students
import com.bassamkhafagy.hafez.repositories.HafezRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HafezViewModel @Inject constructor(private val repository: HafezRepository) : ViewModel() {

    private val _sheikhLiveDate = MutableLiveData<String>()
    val sheikhLiveDate: LiveData<String> = _sheikhLiveDate

    private val _surahLiveDate = MutableLiveData<String>()
    val surahLiveDate: LiveData<String> = _surahLiveDate

    private val _stateLiveDate = MutableLiveData<String>()
    val stateLiveDate: LiveData<String> = _stateLiveDate


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
}


//    private val _taskLiveDate = MutableLiveData<Task>()
//    val taskLiveDate: LiveData<Task> = _taskLiveDate
//
//    private val _dateLiveDate =
//        MutableSharedFlow<Resource<Pair<String, String>>>()
//    val dateLiveDate = _dateLiveDate.asSharedFlow()
//
//    private val _insertionState =
//        MutableSharedFlow<Resource<String>>()
//    val insertionState = _insertionState.asSharedFlow()

//    private val _priorityLiveDate =
//        MutableSharedFlow<String>()
//    val priorityLiveDate = _priorityLiveDate.asSharedFlow()
//
//    private val _assigneesLiveDate =
//        MutableSharedFlow<String>()
//    val assigneesLiveDate = _assigneesLiveDate.asSharedFlow()
//
//    private val _ccAssigneesLiveDate =
//        MutableSharedFlow<String>()
//    val ccAssigneesLiveDate = _ccAssigneesLiveDate.asSharedFlow()
//
//    suspend fun insertTask(task: Task) {
//        viewModelScope.launch(Dispatchers.IO) {
//            _insertionState.emit(Resource.Loading())
//            if (repository.insertTask(task) > 0) {
//                _insertionState.emit(Resource.Success("Data inserted successfully"))
//            } else {
//                _insertionState.emit(Resource.Error("Data not inserted"))
//            }
//        }
//    }
//
//    suspend fun getAllTasks() = repository.getAllTasks()
//
//    fun getTaskByID(id: Long) {
//        _taskLiveDate.postValue(repository.getTaskById(id))
//    }
