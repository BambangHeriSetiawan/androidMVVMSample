package com.simx.mvvmdatabindingsample.main.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.simx.mvvmdatabindingsample.R
import com.simx.mvvmdatabindingsample.data.local.AppDatabase
import com.simx.mvvmdatabindingsample.databinding.DialogAddUserBinding

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class AddUserDialogFragment:BottomSheetDialogFragment(), DialogPresenter {
    lateinit var dialogAddUserBinding: DialogAddUserBinding
    lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialogAddUserBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_add_user,container,false)
        dialogAddUserBinding.setLifecycleOwner(this)
        /*val factory = InjectorTools.provideDialogAddViewModer(this)*/
        var dialogAddViewModel = DialogAddViewModel(this,AppDatabase.getInstance(this.context!!).userDao())
        dialogAddUserBinding.dialogAddVm = dialogAddViewModel

        /*dialog.setOnShowListener { dialog: DialogInterface? ->
            val d = dialog as BottomSheetDialog
            val bottomSheetInternal = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetInternal!!)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }*/
        return dialogAddUserBinding.root
    }

    override fun dismisDialog() {
        dialog.dismiss()
    }
}