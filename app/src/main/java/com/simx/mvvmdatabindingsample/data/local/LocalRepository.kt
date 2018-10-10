package com.simx.mvvmdatabindingsample.data.local

import com.simx.mvvmdatabindingsample.data.entity.User

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
object LocalRepository {
    fun sampleUsers():List<User>{
        return listOf(
                User("Heri", "Setiawan"),
                User("Bambang", "Setiawan"),
                User("Bambang Heri", "Setiawan")
        )
    }

}