package com.example.todokmm.data.todo

import com.example.todokmm.domain.todo.Todo
import database.TodoEntity

fun TodoEntity.toTodo(): Todo {
    return Todo(
        userId = userId,
        id = id,
        title = title,
        completed = completed,
        colorHex = colorHex
    )
}