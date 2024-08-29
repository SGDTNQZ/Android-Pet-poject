package com.littlelemon.petproject.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.littlelemon.petproject.entities.UserEntity


@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase(){
    companion object {
        const val NAME = "App_DB"
    }

    abstract fun getUserDao() : UserDao
}