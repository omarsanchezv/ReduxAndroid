package com.example.reduxandroid.di

import com.example.reduxandroid.simplest.SimplestReducer
import com.example.reduxandroid.simplest.SimplestState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SimplestModule {

    @Provides
    fun provideSimplestReducer(): SimplestReducer = SimplestReducer()

    @Provides
    fun provideSimplestState(): SimplestState = SimplestState()
}