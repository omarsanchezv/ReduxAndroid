package com.example.reduxandroid.potholes

import com.example.reduxandroid.base.BaseAction

sealed class PotholesAction: BaseAction {
    data class Click(val position: Position):PotholesAction()
    data class InitLevel(val level: Level): PotholesAction()
    data class FlagSquare(val position: Position):PotholesAction()
    object GameOver: PotholesAction()

}