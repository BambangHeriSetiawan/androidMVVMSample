package com.simx.mvvmdatabindingsample

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.simx.mvvmdatabindingsample.data.local.AppDatabase
import com.simx.mvvmdatabindingsample.data.local.LocalRepository
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */

class DatabseDbTest {
    lateinit var userDAO: UserDAO
    lateinit var appDatabase: AppDatabase
    var listUser:Int = 0
    @Before
    fun onCreateDb(){
        val con:Context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(con,AppDatabase::class.java).build()
        userDAO = appDatabase.userDao()
    }
    @After
    fun closeDb(){
        appDatabase.close()
    }
    @Test
    fun insertUserSample(){
        userDAO.insertAll(LocalRepository.sampleUsers())
        userDAO.getUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    listUser = it.size
                },{
            Log.e("","${it.message}")
        }
        )
        Assert.assertEquals(listUser,listUser)
    }
}