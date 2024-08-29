package com.littlelemon.petproject.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    val firebaseUserId: String,
    val email: String,
    val name: String,
    val sex: String,
    val weight: Float,
    val height: Float,
    val createdAt: Date
)
