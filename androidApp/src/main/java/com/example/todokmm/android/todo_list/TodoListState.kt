package com.example.todokmm.android.todo_list

import com.example.todokmm.domain.todo.Todo

data class TodoListState(
    val todos: List<Todo> = emptyList()
)
