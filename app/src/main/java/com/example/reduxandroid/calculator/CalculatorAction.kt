package com.example.reduxandroid.calculator

import com.example.reduxandroid.base.BaseAction
import com.example.reduxandroid.base.ViewAction

sealed class CalculatorAction : BaseAction {
    data class AddNumber (val value: Int) : CalculatorAction()
    object Add: CalculatorAction()
}

sealed class CalculatorViewAction: ViewAction {
    // this actions are related with the view itself
    // like showing an Error Screen, loading screen etc.
}
