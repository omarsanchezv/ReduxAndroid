package com.example.reduxandroid.simplest

import com.example.reduxandroid.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SimplestStore @Inject constructor(
    reducer: SimplestReducer,
    state: SimplestState
) : Store<SimplestState>(reducer, state)