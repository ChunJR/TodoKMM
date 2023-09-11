package com.example.todokmm

import com.example.todokmm.di.KodeinInjector
import com.example.todokmm.repository.TodoUseCase
import org.kodein.di.instance
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object UseCaseProvider {
    val todoUseCase by KodeinInjector.instance<TodoUseCase>()
}