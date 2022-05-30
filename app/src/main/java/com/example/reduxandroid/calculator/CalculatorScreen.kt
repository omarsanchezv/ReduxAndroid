package com.example.reduxandroid.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reduxandroid.base.Dispatch
import com.example.reduxandroid.calculator.CalculatorAction.Add
import com.example.reduxandroid.calculator.CalculatorAction.AddNumber
import com.example.reduxandroid.ui.theme.ReduxAndroidTheme

@Composable
fun calculatorScreen(state: CalculatorState, dispatch: Dispatch) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = state.screenText,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                textAlign = TextAlign.End
            )
            Text(
                text = "0",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 50.sp,
                textAlign = TextAlign.End
            )
        }
        Row(modifier = Modifier.weight(3f)) {
            Column(
                Modifier.weight(3f)
            ) {
                ButtonGroup(
                    text1 = 7,
                    text2 = 8,
                    text3 = 9,
                    modifier = Modifier.weight(1f),
                    dispatch = dispatch
                )
                ButtonGroup(
                    text1 = 4,
                    text2 = 5,
                    text3 = 6,
                    modifier = Modifier.weight(1f),
                    dispatch = dispatch
                )
                ButtonGroup(
                    text1 = 1,
                    text2 = 2,
                    text3 = 3,
                    modifier = Modifier.weight(1f),
                    dispatch = dispatch
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            ) {
                addButton(dispatch = dispatch, modifier = Modifier.weight(1f))
                addButton(dispatch = dispatch, modifier = Modifier.weight(1f))
                addButton(dispatch = dispatch, modifier = Modifier.weight(1f))
                addButton(dispatch = dispatch, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun ButtonGroup(text1: Int, text2: Int, text3: Int, modifier: Modifier, dispatch: Dispatch) {
    Row(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            numberButton(
                text = text1,
                dispatch = dispatch
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            numberButton(
                text = text2,
                dispatch = dispatch
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            numberButton(
                text = text3,
                dispatch = dispatch
            )
        }
    }
}

@Composable
fun numberButton(text: Int, dispatch: Dispatch) {
    Button(
        onClick = { dispatch?.invoke(AddNumber(text)) },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {
        Text(
            text = text.toString(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun addButton(dispatch: Dispatch, modifier: Modifier) {
    Button(
        onClick = { dispatch?.invoke(Add) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        )
    ) {
        Text(
            text = "+",
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    ReduxAndroidTheme(darkTheme = false) {
        calculatorScreen(state = CalculatorState(), dispatch = {})
    }
}
