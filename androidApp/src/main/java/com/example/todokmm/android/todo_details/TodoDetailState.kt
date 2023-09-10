package com.example.todokmm.android.todo_details

data class TodoDetailState(
    val todoTitle: String = "",
    val isTodoTitleHintVisible: Boolean = false,
    val todoCompleted: String = "",
    val isTodoCompletedHintVisible: Boolean = false,
    val todoColor: Long = 0xFFFFFF
)
