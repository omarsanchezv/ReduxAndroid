package com.example.reduxandroid.calculator

import com.example.reduxandroid.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorStore @Inject constructor(
    calculatorReducer: CalculatorReducer,
    calculatorState: CalculatorState
) : Store<CalculatorState>(calculatorReducer,calculatorState)