package com.example.todokmm.android.todo_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val todos by viewModel.todos.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.loadTodos()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("todo_detail/-1L")
                },
                backgroundColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add todo",
                    tint = Color.White
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "All todos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(
                    items = todos,
                    key = { it.id!! }
                ) { todo ->
                    TodoItem(
                        todo = todo,
                        backgroundColor = Color(todo.colorHex),
                        onTodoClick = {
                            navController.navigate("todo_detail/${todo.id}")
                        },
                        onDeleteClick = {
                            viewModel.deleteTodoById(todo.id!!)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .animateItemPlacement()
                    )
                }
            }
        }
    }
}