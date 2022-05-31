package com.example.reduxandroid.simplest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reduxandroid.base.Dispatch

@Composable
fun SimplestScreen(state: SimplestState, dispatch: Dispatch){
    var phone by remember { mutableStateOf(state.text)}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)){

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(Color.White)
            .height(200.dp)
            .weight(.5f)
        ) {
            Text(
                text = state.text,
                modifier = Modifier.align(Alignment.BottomEnd),
                color = Color.Black
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .weight(1f)
        ){
            TextField(value = phone, onValueChange = {phone = it}, modifier = Modifier.fillMaxWidth())
        }
        Button(onClick = { dispatch?.invoke(SimplestAction.Click(phone)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(text = "click action")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun screenPreview(){
    SimplestScreen(state = SimplestState(text = "hi"), dispatch = {})
}