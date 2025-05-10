package com.example.wilowachin.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()

    fun updateEmail(input: String) {
        _email.value = input
    }

    fun updateUsername(input: String) {
        _username.value = input
    }

    fun updatePassword(input: String) {
        _password.value = input
    }

    fun updateConfirmPassword(input: String) {
        _confirmPassword.value = input
    }
}