package com.example.todokmm.domain.todo

interface LocalDataSource {
    suspend fun insertTodo(todo: Todo)
    suspend fun getTodoById(id: Long): Todo?
    suspend fun getAllTodos(): List<Todo>
    suspend fun deleteTodoById(id: Long)
}