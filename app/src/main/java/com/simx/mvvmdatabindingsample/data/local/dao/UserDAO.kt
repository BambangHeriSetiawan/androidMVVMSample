package com.simx.mvvmdatabindingsample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.simx.mvvmdatabindingsample.data.entity.User
import io.reactivex.Flowable

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
@Dao
interface UserDAO {
    @Query("SELECT * FROM users ORDER BY FirsName")
    fun getUsers():Flowable<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUsersById(id:String):LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(vararg user: User)

    @Delete
    fun deleteAll(user: List<User>)

    @Query("DELETE FROM users WHERE id = :id")
    fun deleteOne(id:Int)

}