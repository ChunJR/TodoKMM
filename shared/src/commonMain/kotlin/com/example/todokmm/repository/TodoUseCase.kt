package com.example.todokmm.repository

import com.example.todokmm.data.remote.ApiResponse
import com.example.todokmm.data.remote.TodoResponse
import com.example.todokmm.network.NetworkClient
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class TodoUseCase(val networkClient: Lazy<NetworkClient>) {

    suspend fun getTodos(): ApiResponse<TodoResponse> {
        return try {
            val response = networkClient.value.getNetworkClient().get<TodoResponse> {
                url {
                    encodedPath = "/todos"
                }
            }
            ApiResponse(true, HttpStatusCode.OK.value, response, null)
        } catch (exception: ResponseException) {
            ApiResponse(false, exception.response.status.value, null, exception)
        }
    }
}