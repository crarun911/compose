package com.dcoders.myusecaseapp.playground.dependency

import android.content.Context
import com.dcoders.myusecaseapp.playground.room.TodoDao
import com.dcoders.myusecaseapp.playground.room.TodoDatatbase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoDatatbase=
        TodoDatatbase.getInstance(context)
    @Provides
    fun provideTodoDao(datatbase: TodoDatatbase): TodoDao=datatbase.todoDao()
}