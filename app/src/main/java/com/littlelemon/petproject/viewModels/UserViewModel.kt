package com.littlelemon.petproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> get() = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> get() = _confirmPassword

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> get() = _name

    private val _age = MutableStateFlow("")
    val age: StateFlow<String> get() = _age

    private val _weight = MutableStateFlow("")
    val weight: StateFlow<String> get() = _weight

    private val _height = MutableStateFlow("")
    val height: StateFlow<String> get() = _height

    private val _signUpStatus = MutableStateFlow("")
    val signUpStatus: StateFlow<String> get() = _signUpStatus

    private val _signInStatus = MutableStateFlow("")
    val signInStatus: StateFlow<String> get() = _signInStatus

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        _confirmPassword.value = newConfirmPassword
    }

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onAgeChange(newAge: String) {
        _age.value = newAge
    }

    fun onWeightChange(newWeight: String) {
        _weight.value = newWeight
    }

    fun onHeightChange(newHeight: String) {
        _height.value = newHeight
    }

    fun signUp(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            viewModelScope.launch {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            _signInStatus.value = "Sign-up successful!"
                        } else {
                            _signInStatus.value = "Sign-up failed: ${task.exception?.message}"
                        }
                    }
            }
        } else {
            _signInStatus.value = "Email and password must not be empty"
        }
    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _signInStatus.value = "Sign-in successful"
                    } else {
                        _signInStatus.value = "Sign-in failed: ${task.exception?.message}"
                    }
                }
        }
    }
}
