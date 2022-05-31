package com.example.reduxandroid.simplest

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.reduxandroid.base.BaseActivity
import com.example.reduxandroid.base.Store
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SimplestActivity : BaseActivity<SimplestState>(){
    private val vm: SimplestStore by viewModels()
    override fun store(): Store<SimplestState> = vm

    @Composable
    override fun Render(state: SimplestState) =
        SimplestScreen(state = state, dispatch = ::dispatch)

}