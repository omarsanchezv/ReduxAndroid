package com.example.reduxandroid.potholes

import com.example.reduxandroid.base.BaseAction
import com.example.reduxandroid.base.Reducer
import com.example.reduxandroid.potholes.PotholesAction.InitLevel
import com.example.reduxandroid.potholes.PotholesAction.Click
import com.example.reduxandroid.potholes.PotholesAction.FlagSquare
import java.util.*

class PotholeReducer : Reducer<PotholesState> {
    override fun reduce(state: PotholesState, action: BaseAction): PotholesState {
        val state = PotholesState(
            level = reduceLevel(state = state, action = action),
            squares = reduceSquares(state = state, action = action),
            isDebug = state.isDebug
        )
        return state
    }
    override fun shouldReduce(action: BaseAction): Boolean = when (action) {
        is Click -> true
        is InitLevel -> true
        is FlagSquare -> true
        else -> false
    }

    private fun reduceLevel(state: PotholesState, action: BaseAction): Level =
        when (action) {
            is InitLevel -> action.level
            is Click -> state.level
            else -> state.level
        }

    private fun reduceSquares(state: PotholesState, action: BaseAction): Array<Array<Square>> =
        when (action) {
            is InitLevel -> fillSquares(action.level)
            is Click -> modifySquare(state, action.position)
            is FlagSquare -> changeFlag(state, action.position)
            else -> state.squares
        }

    private fun fillSquares(level: Level): Array<Array<Square>> {
        var rowOfSquares: Array<Array<Square>> = arrayOf()
        val list = LinkedList<Square>()
        for (i in 0 until level.numColumns * level.numRows) {
            list.push(
                Square(
                    isPothole = i < level.potholeQuantity
                )
            )
        }
        list.shuffle()
        for (row in 0 until level.numRows) {
            var colArray = arrayOf<Square>()
            for (col in 0 until level.numColumns) {
                val square = list.pop()
                square.position = Position(row, col)
                colArray += square
            }
            rowOfSquares += colArray
        }
        return rowOfSquares
    }

    private fun modifySquare(state: PotholesState, position: Position): Array<Array<Square>> {
        val square = state.squares[position.row][position.col]
        return if (square.isFlagged) {
            state.squares
        } else {
            click(state, position)
        }
    }

    private fun changeFlag(state: PotholesState, position: Position) =
        state.squares.apply {
            this[position.row][position.col].isFlagged = !this[position.row][position.col].isFlagged
            this[position.row][position.col].color =
                if (this[position.row][position.col].isFlagged) {
                    SquareColorState.FLAGGED
                } else {
                    SquareColorState.NORMAL
                }
        }

    private fun click(state: PotholesState, position: Position): Array<Array<Square>> =
        state.squares.apply {
            this[position.row][position.col].apply {
                potholeAround = getAround(position = position, state = state)
                color = SquareColorState.CLICKED
            }
        }

    private fun getAround(position: Position, state: PotholesState): Int {
        val level = state.level
        var potholeCounter = 0
        val startRow = maxOf(position.row - 1, 0)
        val endRow = minOf(level.numRows - 1, position.row + 1)
        val startCol = maxOf(position.col - 1, 0)
        val endCol = minOf(level.numColumns - 1, position.col + 1)
        for (_row in startRow..endRow) {
            for (_col in startCol..endCol) {
                if (state.squares[_row][_col].isPothole) {
                    potholeCounter++
                }
            }
        }
        return potholeCounter
    }


//    private fun clickArround(col: Int,row: Int){
//        val startRow = maxOf(row-1, 0)
//        val endRow = minOf(NUM_OF_ROW -1, row+1)
//        val startCol = maxOf(col-1, 0)
//        val endCol = minOf(NUM_OF_COLUMNS-1, col+1)
//        for (_row in startRow..endRow){
//            for (_col in startCol..endCol){
//                rowOfBoxes[_row][_col].apply {
//                    arround = getArround(_col,_row)
//                    view?.text = arround.toString()
//                    view?.setBackgroundColor(Color.GRAY)
//
//                }
//            }
//        }
//    }
}