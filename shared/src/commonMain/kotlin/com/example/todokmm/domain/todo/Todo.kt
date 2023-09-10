package com.example.todokmm.domain.todo

import com.example.todokmm.presentation.*

data class Todo(
    val userId: Long?,
    val id: Long?,
    val title: String,
    val completed: String,
    val colorHex: Long
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}
