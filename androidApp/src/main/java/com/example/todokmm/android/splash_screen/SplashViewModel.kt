package com.example.todokmm.android.splash_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SplashViewModel: ViewModel() {
//    private val networkUseCase: TodoUseCase = UseCaseProvider.todoUseCase

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

//    init {
//        viewModelScope.launch {
//            kotlin.runCatching {
////                networkUseCase.getTodos()
//            }.onSuccess {
//                    _onBoardingCompleted.value = it.isSuccess
//                    Log.e("Status!!! + " + it.isSuccess, it.data.toString())
//            }.onFailure {
//                Log.e("Throwableeee!!!", it.toString())
//            }
//        }
//    }
}