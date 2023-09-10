package com.example.todokmm.android.todo_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todokmm.domain.todo.Todo
import com.example.todokmm.domain.todo.TodoDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoDataSource: TodoDataSource,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val todos = savedStateHandle.getStateFlow("todos", emptyList<Todo>())

    fun loadTodos() {
        viewModelScope.launch {
            savedStateHandle["todos"] = todoDataSource.getAllTodos()
        }
    }

    fun deleteTodoById(id: Long) {
        viewModelScope.launch {
            todoDataSource.deleteTodoById(id)
            loadTodos()
        }
    }
}