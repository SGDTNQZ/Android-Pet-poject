package com.littlelemon.petproject.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class ExerciseEntity (

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var exerciseName : String,
    var weight : Float,
    var reps : Int,
    var set : Int,
    var createdAt: Date
)