package com.example.reduxandroid.potholes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reduxandroid.base.Dispatch
import com.example.reduxandroid.ui.theme.ReduxAndroidTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PotholeScreen(state: PotholesState, dispatch: Dispatch) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(state.level.numColumns),
    ) {
        if (state.squares.isEmpty()) return@LazyVerticalGrid

        for (row in 0 until state.level.numRows) {
            for (col in 0 until state.level.numColumns) {
                item {
                    val square = state.squares[row][col]
                    if (state.isDebug && square.isPothole) {
                        square.color = SquareColorState.POTHOLE
                    }
                    SquareView(square = square, dispatch = dispatch)
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SquareView(square: Square, dispatch: Dispatch) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .background(
                color =
                when (square.color) {
                    SquareColorState.NORMAL -> MaterialTheme.colors.onBackground
                    SquareColorState.POTHOLE -> Color.Red
                    SquareColorState.CLICKED -> Color.Gray
                    SquareColorState.FLAGGED -> MaterialTheme.colors.onBackground
                }
            )
            .combinedClickable(
                onClick = {
                    if (square.isFlagged) {
                        return@combinedClickable
                    }

                    if (square.isPothole) {
                        dispatch?.invoke(PotholesAction.GameOver)
                    } else {
                        square.position?.let {
                            dispatch?.invoke(PotholesAction.Click(it))
                        }
                    }
                },
                onLongClick = {
                    square.position?.let {
                        dispatch?.invoke(PotholesAction.FlagSquare(it))
                    }
                },
            ),
        contentAlignment = Alignment.Center
    ) {
        if (square.isFlagged) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colors.background,
            )
        } else {
            Text(
                text = "(${square.position?.row}, ${square.position?.col})",
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    ReduxAndroidTheme(darkTheme = false) {
        SquareView(square = Square(), dispatch = {})
    }
}
