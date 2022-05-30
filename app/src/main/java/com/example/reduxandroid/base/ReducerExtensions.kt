package com.example.reduxandroid.base

fun <T> Reducer<T>.reduceStateFromAction(state: T, action: BaseAction) = when (this.shouldReduce(action)) {
    true -> this.reduce(state, action)
    false -> state
}