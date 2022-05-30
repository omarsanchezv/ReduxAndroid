package com.example.reduxandroid.potholes

import com.example.reduxandroid.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PotholeStore @Inject constructor(
    reducer: PotholeReducer,
    state: PotholesState
): Store<PotholesState>(reducer, state)