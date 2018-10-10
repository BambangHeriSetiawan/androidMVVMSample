package com.simx.mvvmdatabindingsample.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
@Entity(tableName = "users")
class User(

        @ColumnInfo(name = "FirsName")
        var firstName:String,
        @ColumnInfo(name = "Lastame")
        var lastName:String

) {



    constructor() : this("","")

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    var id:Int = 0

    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', id=$id)"
    }

}