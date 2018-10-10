package com.simx.mvvmdatabindingsample

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.simx.mvvmdatabindingsample.data.local.AppDatabase
import com.simx.mvvmdatabindingsample.data.local.LocalRepository
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class Apps:Application() {
    lateinit var userDAO: UserDAO
    lateinit var appDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(this,AppDatabase::class.java,"sample")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(
                        object : RoomDatabase.Callback(){
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Log.e("onCreate","onCreate")
                                appDatabase.userDao().insertAll(LocalRepository.sampleUsers())
                            }

                            override fun onOpen(db: SupportSQLiteDatabase) {
                                super.onOpen(db)
                                Log.e("onOpen","onOpen")
                            }
                        }

        ).build()
    }
}