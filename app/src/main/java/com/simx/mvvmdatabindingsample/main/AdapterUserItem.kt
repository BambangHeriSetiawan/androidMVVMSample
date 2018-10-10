package com.simx.mvvmdatabindingsample.main


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simx.mvvmdatabindingsample.data.entity.User
import com.simx.mvvmdatabindingsample.databinding.ItemUserBinding

/**
 * Create by simx on 09/10/18
 * Develop by Bambang Heri Setiawan
 * Email setiawan.heri.bambang@gmail,com / heri@iglobal.co.id
 * Copyright (c) 2018 |  iGlobalTech (PT. Iglobal Nusa Persada)
 */
class AdapterUserItem(var listUser:List<User>?, var listener:AdapterUserItem.OnAdapterUserItemListener): RecyclerView.Adapter<AdapterUserItem.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var itemBinding = ItemUserBinding.inflate(LayoutInflater.from(p0.context),p0,false)
        return Holder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listUser!!.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        var user: User = listUser!![p1]
        p0.bind(user)
        p0.itemView.setOnClickListener {
            listener.onAdapterUserItemClicked(user)
        }
    }

    fun setUsers(users:List<User>?){
        this.listUser = users
        notifyDataSetChanged()
    }

    class Holder(var itemBinding: ItemUserBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(user: User) {
            with(itemBinding){
                userItem = UserItemViewModel(user)
                executePendingBindings()
            }
        }

    }
    interface OnAdapterUserItemListener{
        fun onAdapterUserItemClicked(user: User)
    }
}