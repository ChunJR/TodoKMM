package com.example.todokmm.data.remote

import kotlinx.serialization.*

@Serializable
data class TodoResponse (
    @Serializable val userId: Long,
    @Serializable val id: Long,
    @Serializable val title: String,
    @Serializable val completed: String
)