package com.simx.mvvmdatabindingsample.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.simx.mvvmdatabindingsample.data.entity.User
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class MainViewModel(var mainPresenter: MainPresenter,var userDAO: UserDAO): ViewModel() {
    @SuppressLint("CheckResult")
    fun showToas(){
        userDAO.getUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {mainPresenter.updateAdapter(it)},
                {Log.e("main Error", "Error ${it.message}")})
    }

    @SuppressLint("CheckResult")
    fun getAllUsers(){
        /*count++
        userDAO.insertOne(User("User $count","User $count"))*/
        /*userDAO.getUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {mainPresenter.updateAdapter(it)},
                {Log.e("main Error", "Error ${it.message}")})*/
        mainPresenter.showToas()
    }

    fun deleteUserOne(user: User) {
        userDAO.deleteOne(user.id)
    }


}