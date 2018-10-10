package com.simx.mvvmdatabindingsample.main.dialog

import android.text.TextWatcher
import androidx.databinding.*
import com.google.android.material.textfield.TextInputEditText
import com.simx.mvvmdatabindingsample.BR
import android.text.Editable
import android.text.TextUtils
import com.simx.mvvmdatabindingsample.data.entity.User
import com.simx.mvvmdatabindingsample.data.local.dao.UserDAO


/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class DialogAddViewModel(var dialogPresenter: DialogPresenter, var userDAO: UserDAO):BaseObservable() {

    @Bindable private var firstName = ObservableField<String>()
    @Bindable private var lastName = ObservableField<String>()

     @Bindable var firstNameError = ObservableField<String>()
     @Bindable var lastNameError = ObservableField<String>()
    init {
        firstNameError.set("Input your Fisrtname here")
        lastNameError.set("Input your Lasttname here")
    }

    fun btnAddClicked(){
        if (!TextUtils.isEmpty(firstName.get()) && !TextUtils.isEmpty(lastName.get())){
            firstNameError.set("")
            lastNameError.set("")
            var user = User(firstName.get()!!, lastName.get()!!)
            userDAO.insertOne(user)
            dialogPresenter.dismisDialog()
        }else if (TextUtils.isEmpty(firstName.get())) {
            firstNameError.set("Last Name is requared")
        } else if (TextUtils.isEmpty(lastName.get())){
            lastNameError.set("Last Name is requared")
        }
    }

    fun firstNameTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                firstName.set(s.toString())
                notifyPropertyChanged(BR.firstName)
            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty())
                    firstNameError.set("Fistname is requared")
                    notifyPropertyChanged(BR.firstNameError)

            }
        }
    }

    fun lastNameTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                lastName.set(s.toString())
                notifyPropertyChanged(BR.lastName)
            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty())
                    lastNameError.set("Lastname is requared")
                    notifyPropertyChanged(BR.lastNameError)
            }
        }
    }
    companion object {
        @BindingAdapter("bind:textWatcher")
        @JvmStatic
        fun textWatcher(editText: TextInputEditText, watcher: TextWatcher){
            editText.addTextChangedListener(watcher)
        }
    }

}