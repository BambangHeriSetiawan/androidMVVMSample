package com.simx.mvvmdatabindingsample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.simx.mvvmdatabindingsample.data.entity.User
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
@Database(entities = [User::class],version = 2,exportSchema = false)
abstract class AppDatabase :RoomDatabase() {
    abstract fun userDao():UserDAO
    companion object {
        @Volatile private var instance:AppDatabase? = null
        fun getInstance(context: Context):AppDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context:Context):AppDatabase {
            return Room.databaseBuilder(context,AppDatabase::class.java,"sample").fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }
}