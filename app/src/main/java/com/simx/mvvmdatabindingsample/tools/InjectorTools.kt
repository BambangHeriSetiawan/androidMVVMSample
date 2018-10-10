package com.simx.mvvmdatabindingsample.tools

import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO
import com.simx.mvvmdatabindingsample.main.MainPresenter
import com.simx.mvvmdatabindingsample.main.MainViewModelFactory
import com.simx.mvvmdatabindingsample.main.dialog.DialogAddViewModelFactory
import com.simx.mvvmdatabindingsample.main.dialog.DialogPresenter

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
object InjectorTools {
    fun provideMainViewModel(mainPresenter: MainPresenter, userDAO: UserDAO): MainViewModelFactory {
        return MainViewModelFactory(mainPresenter,userDAO)
    }
    fun provideDialogAddViewModer(dialogPresenter: DialogPresenter, userDAO: UserDAO):DialogAddViewModelFactory{
        return DialogAddViewModelFactory(dialogPresenter,userDAO)
    }
}