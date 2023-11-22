package com.example.ozlembasabakar.model

data class Login(
    val apiVersion: String?,
    val oauth: Oauth?,
    val permissions: List<String?>?,
    val showPasswordPrompt: Boolean?,
    val userInfo: UserInfo?
)