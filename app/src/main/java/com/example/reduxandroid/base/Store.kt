package com.example.reduxandroid.base

import androidx.lifecycle.ViewModel
import com.example.reduxandroid.calculator.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Store <S: BaseState>(
    reducer: Reducer<S>,
    state: S
        ) : ViewModel(), BaseStore<S> by BaseStoreImp(reducer,state)