package com.example.todokmm.android.splash_screen

data class SplashState(
    val todoTitle: String = "",
    val isTodoTitleHintVisible: Boolean = false,
    val todoCompleted: String = "",
    val isTodoCompletedHintVisible: Boolean = false,
    val todoColor: Long = 0xFFFFFF
)
