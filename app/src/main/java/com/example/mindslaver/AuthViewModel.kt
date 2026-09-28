package com.example.mindslaver

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var email by mutableStateOf("planeswalker@mtg.com")
    var password by mutableStateOf("mindslaves123")
    var isLoggedIn by mutableStateOf(false)
        private set

    var loginError by mutableStateOf<String?>(null)
        private set

    fun login() {
        if (email.isNotBlank() && password.length >= 6) {
            isLoggedIn = true
            loginError = null
        } else {
            loginError = "Please enter valid credentials (password min 6 chars)"
        }
    }

    fun logout() {
        isLoggedIn = false
    }
}
