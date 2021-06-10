package com.example.tango.view.viewmodels

import androidx.lifecycle.*
import com.example.tango.domain.models.MyModel
import com.example.tango.domain.repositories.PositionsRepository
import kotlinx.coroutines.*

@Suppress("UNCHECKED_CAST")
class PositionsViewModelFactory(
    private val repository: PositionsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PositionsViewModel(repository) as T
    }

}

class PositionsViewModel(
    private val repository: PositionsRepository
) : ViewModel() {

    private val _positions = MutableLiveData<List<MyModel>>()
    val positions: LiveData<List<MyModel>> = _positions

    private val _exception = MutableLiveData<Exception>()
    val exception: LiveData<Exception> = _exception

    fun fetchPositions() {
        val job = viewModelScope.async(Dispatchers.IO) {
            repository.fetchPositions()
        }
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val positions = job.await()
                this@PositionsViewModel._positions.postValue(positions)
            } catch (ex: Exception) {
                this@PositionsViewModel._exception.postValue(ex)
            }
        }
    }

}
