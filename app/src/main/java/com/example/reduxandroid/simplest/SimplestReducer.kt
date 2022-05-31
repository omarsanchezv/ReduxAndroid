package com.example.reduxandroid.simplest

import com.example.reduxandroid.base.BaseAction
import com.example.reduxandroid.base.Reducer

class SimplestReducer: Reducer<SimplestState> {
    override fun reduce(state: SimplestState, action: BaseAction): SimplestState =
        SimplestState(
            text = reduceText(action)
        )

    override fun shouldReduce(action: BaseAction): Boolean =
        when (action){
            is SimplestAction.Click -> true
            else -> false
        }

    private fun reduceText(action: BaseAction) : String=
        when(action){
            is SimplestAction.Click -> action.text
            else -> ""
        }
}