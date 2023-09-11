package com.example.todokmm.data.remote

class ApiResponse<T> (
    val isSuccess: Boolean,
    val statusCode: Int,
    val data: T?,
    val exception: Throwable?
)