package com.example.todokmm.data.todo

import com.example.todokmm.database.TodoDatabase
import com.example.todokmm.domain.todo.Todo
import com.example.todokmm.domain.todo.TodoDataSource

class SqlDelightTodoDataSource(db: TodoDatabase): TodoDataSource {

    private val queries = db.todoQueries

    override suspend fun insertTodo(todo: Todo) {
        queries.insertTodo(
            userId = todo.userId,
            id = todo.id,
            title = todo.title,
            completed = todo.completed,
            colorHex = todo.colorHex
        )
    }

    override suspend fun getTodoById(id: Long): Todo? {
        return queries
            .getTodoById(id)
            .executeAsOneOrNull()
            ?.toTodo()
    }

    override suspend fun getAllTodos(): List<Todo> {
        return queries
            .getAllTodos()
            .executeAsList()
            .map { it.toTodo() }
    }

    override suspend fun deleteTodoById(id: Long) {
        queries.deleteTodoById(id)
    }
}