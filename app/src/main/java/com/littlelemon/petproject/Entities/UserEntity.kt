package com.littlelemon.petproject.Entities

import android.provider.ContactsContract.Data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var userEmail : String,
    var userName : String,
    var userWeight : Float,
    var userHeight : Float,
    var userCreatedAt : Data
)

