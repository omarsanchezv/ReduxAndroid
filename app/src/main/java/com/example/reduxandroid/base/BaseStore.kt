package com.example.reduxandroid.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface BaseStore<S: BaseState> {

    fun dispatch(action: BaseAction)
    val stateFlow: StateFlow<S>
}

class BaseStoreImp<S: BaseState>(private val reducer: Reducer<S>, state: S) : BaseStore<S>{
    private val _state = MutableStateFlow(state)
    override val stateFlow: StateFlow<S> = _state

    override fun dispatch(action: BaseAction) {
            _state.value = reducer.reduceStateFromAction(
                state = stateFlow.value,
                action = action
            )
    }
}