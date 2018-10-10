package com.simx.mvvmdatabindingsample.main.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO

@Suppress("UNCHECKED_CAST")
/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class DialogAddViewModelFactory( var dialogPresenter: DialogPresenter,var userDAO: UserDAO): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DialogAddViewModel(dialogPresenter,userDAO) as T
    }
}