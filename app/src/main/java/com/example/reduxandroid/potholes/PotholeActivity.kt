package com.example.reduxandroid.potholes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.reduxandroid.base.BaseActivity
import com.example.reduxandroid.base.Store
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PotholeActivity : BaseActivity<PotholesState>() {
    private val vm: PotholeStore by viewModels()
    override fun store(): Store<PotholesState> = vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dispatch(PotholesAction.InitLevel(vm.stateFlow.value.level))
    }

    @Composable
    override fun Render(state: PotholesState) {
        PotholeScreen(state = state, dispatch = ::dispatch)
    }


}