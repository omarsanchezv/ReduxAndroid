package com.example.reduxandroid.base

interface Action

interface BaseAction : Action
interface ViewAction : Action

interface BaseState

typealias Dispatch = ((BaseAction) -> Unit)?