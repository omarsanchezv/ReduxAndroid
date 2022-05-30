package com.example.reduxandroid.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.reduxandroid.ui.theme.ReduxAndroidTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


abstract class BaseActivity<S : BaseState> : ComponentActivity(), BaseReduxView<S> {
    lateinit var store: Store<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store = initStore()
        setContent {
            val state by store.stateFlow.collectAsState()
            ReduxAndroidTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Render(state = state)
                }
            }
        }
    }

    protected fun dispatch(action: BaseAction) = store.dispatch(action = action)

    private fun initStore(): Store<S> = store()
}

interface BaseReduxView<S : BaseState> {
    fun store(): Store<S>

    @Composable
    fun Render(state: S)
}
