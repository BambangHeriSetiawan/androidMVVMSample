package com.simx.mvvmdatabindingsample.main


import androidx.lifecycle.ViewModelProvider
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO


@Suppress("UNCHECKED_CAST")
/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class MainViewModelFactory(var mainPresenter: MainPresenter, var userDAO: UserDAO): ViewModelProvider.NewInstanceFactory() {
    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainPresenter, userDAO) as T
    }
}