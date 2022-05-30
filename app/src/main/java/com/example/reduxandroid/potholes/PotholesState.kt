package com.example.reduxandroid.potholes

import com.example.reduxandroid.base.BaseState

data class PotholesState(
    val level: Level = Level(),
    val squares : Array<Array<Square>> = arrayOf(),
    val isDebug: Boolean
): BaseState {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PotholesState

        if (level != other.level) return false
        if (!squares.contentDeepEquals(other.squares)) return false
        if (isDebug != other.isDebug) return false

        return true
    }

    override fun hashCode(): Int {
        var result = level.hashCode()
        result = 31 * result + squares.contentDeepHashCode()
        result = 31 * result + isDebug.hashCode()
        return result
    }
}

data class Square(
    var position: Position? = null,
    var isPothole: Boolean = false,
    var isFlagged: Boolean = false,
    var potholeAround: Int = 0,
    var color: SquareColorState = SquareColorState.NORMAL
)

data class Level(
    val numColumns: Int = 20,
    val numRows: Int = 10,
    val potholeQuantity: Int = 10
)

data class Position(val row: Int,val col: Int)

enum class SquareColorState {
    NORMAL,
    FLAGGED,
    CLICKED,
    POTHOLE
}



