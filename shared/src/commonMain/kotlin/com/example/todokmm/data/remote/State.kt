package com.example.todokmm.data.remote

import com.example.todokmm.domain.todo.Todo

sealed class State {
    object empty: State()
    object loading: State()
    class result(val data: List<Todo>): State()
    class error(val message: String): State()
}