package com.littlelemon.petproject.viewModels

import android.icu.util.Calendar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.littlelemon.petproject.MainApplication
import com.littlelemon.petproject.db.UserDao
import com.littlelemon.petproject.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class UserViewModel : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

//
    val userDao = MainApplication.userDatabase.getUserDao()

    val userList : LiveData<List<UserEntity>> = userDao.getUser()

    fun deleteUser(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(id)
        }
    }

    fun addUser(
        firebaseUserId: String,
        email : String,
        name : String,
        weight  : Float,
        height : Float,
        sex : String,
        ){
        viewModelScope.launch(Dispatchers.IO){
            userDao.addUser(UserEntity(
                firebaseUserId = firebaseUserId,
                email = email,
                name = name,
                weight = weight,
                height = height,
                sex = sex,
                createdAt = Calendar.getInstance().time
            ))
        }
    }

    fun getUserByFirebaseId(firebaseUserId: String): LiveData<UserEntity?> {
        return userDao.getUserByFirebaseId(firebaseUserId)
    }
    fun deleteUserAccount(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            // Delete user from local database
            userDao.deleteUser(userId)

            // Firebase user deletion
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            firebaseUser?.delete()?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Successfully deleted Firebase user
                    // Optionally, you can update the UI or notify the user
                    // For example, you might want to update the auth state
                    _authState.postValue(AuthState.Unauthenticated)
                } else {
                    // Handle Firebase deletion error
                    // You can log the error or notify the user
                    _authState.postValue(AuthState.Error(task.exception?.message ?: "Failed to delete account"))
                }
            }
        }
    }
    //
    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.Unauthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }

    fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or Password is not filled")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }

    fun signUp(
               email: String,
               password: String,
               name: String,
               weight: Float,
               height: Float,
               sex: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or Password is not filled")
            return
        }

        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    val firebaseUserId = firebaseUser?.uid ?: ""
                    _authState.value = AuthState.Authenticated
                    addUser(firebaseUserId,email, name, weight, height, sex)  // Add user to the database
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }

    fun signOut() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()

    data class Error(val message: String) : AuthState()
}
