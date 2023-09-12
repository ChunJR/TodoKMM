package com.example.todokmm.android.todo_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todokmm.domain.todo.Todo
import com.example.todokmm.domain.todo.TodoDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val todoDataSource: TodoDataSource,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val todoTitle = savedStateHandle.getStateFlow("todoTitle", "")
    private val isTodoTitleFocused = savedStateHandle.getStateFlow("isTodoTitleFocused", false)
    private val todoCompleted = savedStateHandle.getStateFlow("todoCompleted", "")
    private val isTodoCompletedFocused = savedStateHandle.getStateFlow("isTodoCompletedFocused", false)
    private val todoColor = savedStateHandle.getStateFlow(
        "todoColor",
        Todo.generateRandomColor()
    )

    val state = combine(
        todoTitle,
        isTodoTitleFocused,
        todoCompleted,
        isTodoCompletedFocused,
        todoColor
    ) { title, isTitleFocused, completed, isCompletedFocused, color ->
        TodoDetailState(
            todoTitle = title,
            isTodoTitleHintVisible = title.isEmpty() && !isTitleFocused,
            todoCompleted = completed,
            isTodoCompletedHintVisible = completed.isEmpty() && !isCompletedFocused,
            todoColor = color
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TodoDetailState())

    private val _hasTodoBeenSaved = MutableStateFlow(false)
    val hasTodoBeenSaved = _hasTodoBeenSaved.asStateFlow()

    private var existingTodoId: Long? = null

    init {
        savedStateHandle.get<Long>("todoId")?.let { existingTodoId ->
            if(existingTodoId == -1L) {
                return@let
            }
            this.existingTodoId = existingTodoId
            viewModelScope.launch {
                todoDataSource.getTodoById(existingTodoId)?.let { todo ->
                    savedStateHandle["todoTitle"] = todo.title
                    savedStateHandle["todoCompleted"] = todo.completed
                    savedStateHandle["todoColor"] = todo.colorHex
                }
            }
        }
    }

    fun onTodoTitleChanged(text: String) {
        savedStateHandle["todoTitle"] = text
    }

    fun onTodoCompletedChanged(text: String) {
        savedStateHandle["todoCompleted"] = text
    }

    fun onTodoTitleFocusChanged(isFocused: Boolean) {
        savedStateHandle["isTodoTitleFocused"] = isFocused
    }

    fun onTodoCompletedFocusChanged(isFocused: Boolean) {
        savedStateHandle["isTodoCompletedFocused"] = isFocused
    }

    fun saveTodo() {
        viewModelScope.launch {
            todoDataSource.insertTodo(
                Todo(
                    userId = -1,
                    id = existingTodoId,
                    title = todoTitle.value,
                    completed = todoCompleted.value,
                    colorHex = todoColor.value,
                )
            )
            _hasTodoBeenSaved.value = true
        }
    }
}