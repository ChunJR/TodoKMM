package com.example.todokmm.android.todo_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TodoDetailScreen(
    todoId: Long,
    navController: NavController,
    viewModel: TodoDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val hasTodoBeenSaved by viewModel.hasTodoBeenSaved.collectAsState()

    LaunchedEffect(key1 = hasTodoBeenSaved) {
        if(hasTodoBeenSaved) {
            navController.popBackStack()
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = viewModel::saveTodo,
                backgroundColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save todo",
                    tint = Color.White
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .background(Color(state.todoColor))
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            TransparentHintTextField(
                text = state.todoTitle,
                hint = "Enter a title...",
                isHintVisible = state.isTodoTitleHintVisible,
                onValueChanged = viewModel::onTodoTitleChanged,
                onFocusChanged = {
                    viewModel.onTodoTitleFocusChanged(it.isFocused)
                },
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = state.todoCompleted,
                hint = "Enter some content...",
                isHintVisible = state.isTodoCompletedHintVisible,
                onValueChanged = viewModel::onTodoCompletedChanged,
                onFocusChanged = {
                    viewModel.onTodoCompletedFocusChanged(it.isFocused)
                },
                singleLine = false,
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier.weight(1f)
            )
        }
    }
}