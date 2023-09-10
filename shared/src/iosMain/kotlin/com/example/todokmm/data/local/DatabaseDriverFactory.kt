package com.example.todokmm.data.local

import com.example.todokmm.database.TodoDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TodoDatabase.Schema, "todo.db")
    }
}