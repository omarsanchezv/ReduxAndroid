package com.example.reduxandroid.base

interface Reducer<S> {
    fun reduce(state: S, action: BaseAction): S
    fun shouldReduce(action: BaseAction): Boolean
}