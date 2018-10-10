package com.simx.mvvmdatabindingsample.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

import com.simx.mvvmdatabindingsample.data.entity.User
import com.squareup.picasso.Picasso

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class UserItemViewModel(var user: User): ViewModel() {
    var firstName = ObservableField<String>(user.firstName  )
    var lastName = ObservableField<String>(user.lastName  )
    var image = ObservableField<String>("https://via.placeholder.com/350x150")

    companion object {
        @BindingAdapter("bind:imageUser")
        @JvmStatic
        fun loadImageUser(imageView: ImageView, image:String){
            Picasso.get().load(image).into(imageView)
        }
    }
}