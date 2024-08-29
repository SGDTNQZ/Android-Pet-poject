package com.littlelemon.petproject.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.littlelemon.petproject.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM USERENTITY")
    fun getUser() :LiveData<List<UserEntity>>

    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("DELETE FROM USERENTITY WHERE id = :id")
    fun deleteUser(id: Int)

    @Query("SELECT * FROM USERENTITY WHERE firebaseUserId = :firebaseUserId")
    fun getUserByFirebaseId(firebaseUserId: String): LiveData<UserEntity?>
}