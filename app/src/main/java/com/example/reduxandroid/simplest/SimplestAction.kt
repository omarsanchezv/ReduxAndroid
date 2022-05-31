package com.example.reduxandroid.simplest

import com.example.reduxandroid.base.BaseAction

sealed class SimplestAction : BaseAction{
    data class Click(val text: String): SimplestAction()
}