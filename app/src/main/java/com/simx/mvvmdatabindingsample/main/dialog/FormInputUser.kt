package com.simx.mvvmdatabindingsample.main.dialog

import androidx.databinding.BaseObservable
import com.simx.mvvmdatabindingsample.data.entity.User

/**
 * Create by simx on 10/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class FormInputUser: BaseObservable() {
    var user: User = User()

    fun isFirstNameValid():Boolean{
        var firsName = user.firstName
        return firsName.length >3
    }
    fun isLastNameValid():Boolean{
        var lastName = user.lastName
        return lastName.length >3
    }
}