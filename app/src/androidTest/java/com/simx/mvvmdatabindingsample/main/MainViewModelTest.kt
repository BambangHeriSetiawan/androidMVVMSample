package com.simx.mvvmdatabindingsample.main

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.simx.mvvmdatabindingsample.data.local.AppDatabase
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class MainViewModelTest {
    lateinit var userDAO: UserDAO
    lateinit var appDatabase: AppDatabase
    @Before
    fun setUp() {
        val conte  = InstrumentationRegistry.getInstrumentation().context
        appDatabase = Room.inMemoryDatabaseBuilder(conte, AppDatabase::class.java).build()
        userDAO = appDatabase.userDao()
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun getAllUsers() {
        var listUser:Int = 0
        appDatabase.userDao().getUsers().subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(
                {t -> listUser = t.size },{}
        )
        assertNull(listUser)
    }
}