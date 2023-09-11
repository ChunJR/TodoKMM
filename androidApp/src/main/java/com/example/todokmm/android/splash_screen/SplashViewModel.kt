package com.example.todokmm.android.splash_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todokmm.UseCaseProvider
import com.example.todokmm.android.todo_details.TodoDetailState
import com.example.todokmm.data.remote.State
import com.example.todokmm.repository.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel: ViewModel() {
    private val networkUseCase: TodoUseCase = UseCaseProvider.todoUseCase

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                networkUseCase.getTodos()
            }.onSuccess {
                    _onBoardingCompleted.value = it.isSuccess
                    Log.e("Status!!! + " + it.isSuccess, it.data.toString())
            }.onFailure {
                Log.e("Throwableeee!!!", it.toString())
            }
        }
    }
}