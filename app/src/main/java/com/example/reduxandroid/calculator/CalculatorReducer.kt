package com.example.reduxandroid.calculator

import com.example.reduxandroid.base.BaseAction
import com.example.reduxandroid.base.Reducer

import com.example.reduxandroid.calculator.CalculatorAction.AddNumber
import com.example.reduxandroid.calculator.CalculatorAction.Add

class CalculatorReducer : Reducer<CalculatorState> {
    override fun reduce(state: CalculatorState, action: BaseAction): CalculatorState {
        return CalculatorState(
            screenValue = reduceValue(state,action),
            screenText = reduceScreenText(state, action)
        )
    }

    override fun shouldReduce(action: BaseAction) = when (action) {
        is AddNumber,
        is Add -> true
        else -> false
    }

    private fun reduceScreenText(state: CalculatorState, action: BaseAction) =
        when (action) {
            is AddNumber -> "${state.screenText}${action.value}"
            is Add -> state.screenText + "+"
            else -> state.screenText
        }

    private fun reduceValue(state: CalculatorState, action: BaseAction) =
        when (action){
            is AddNumber -> state.screenValue + action.value
            is Add -> state.screenValue
            else -> state.screenValue
        }
}