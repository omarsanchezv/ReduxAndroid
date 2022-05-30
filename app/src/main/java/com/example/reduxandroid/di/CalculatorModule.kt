package com.example.reduxandroid.di

import com.example.reduxandroid.calculator.CalculatorReducer
import com.example.reduxandroid.calculator.CalculatorState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class CalculatorModule {

    @Provides
    fun provideCalculatorReducer(): CalculatorReducer = CalculatorReducer()

    @Provides
    fun provideCalculatorState(): CalculatorState = CalculatorState()

}