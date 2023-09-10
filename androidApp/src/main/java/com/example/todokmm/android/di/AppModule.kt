package com.example.todokmm.android.di

import android.app.Application
import com.example.todokmm.data.local.DatabaseDriverFactory
import com.example.todokmm.data.todo.SqlDelightTodoDataSource
import com.example.todokmm.database.TodoDatabase
import com.example.todokmm.domain.todo.TodoDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideTodoDataSource(driver: SqlDriver): TodoDataSource {
        return SqlDelightTodoDataSource(TodoDatabase(driver))
    }
}