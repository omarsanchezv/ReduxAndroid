package com.example.reduxandroid.di

import com.example.reduxandroid.potholes.Level
import com.example.reduxandroid.potholes.PotholeReducer
import com.example.reduxandroid.potholes.PotholesState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PotholeModule {

    @Provides
    fun providePotholeState(level: Level): PotholesState = PotholesState(level = level, isDebug = true)

    @Provides
    fun providesDefaultLevel() = Level()

    @Provides
    fun providesPotholeReducer() = PotholeReducer()
}