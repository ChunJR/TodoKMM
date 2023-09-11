package com.example.todokmm.di

import com.example.todokmm.network.NetworkClient
import com.example.todokmm.repository.TodoUseCase
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val KodeinInjector = DI {
    val client = lazy {
        NetworkClient()
    }
    bindSingleton { TodoUseCase(client) }
}