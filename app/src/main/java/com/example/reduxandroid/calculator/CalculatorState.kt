package com.example.reduxandroid.calculator

import com.example.reduxandroid.base.BaseState

data class CalculatorState(
    val screenText: String = "0",
    val screenValue: Int = 0
) : BaseState
