package com.example.reduxandroid.calculator

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.reduxandroid.base.BaseActivity
import com.example.reduxandroid.base.Store
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculatorActivity: BaseActivity<CalculatorState>() {
    private val vm : CalculatorStore by viewModels()
    @Composable
    override fun Render(state: CalculatorState) {
        calculatorScreen(state = state, dispatch = ::dispatch)
    }

    override fun store(): Store<CalculatorState> {
       return vm
    }
}