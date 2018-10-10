package com.simx.mvvmdatabindingsample.main


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.simx.mvvmdatabindingsample.R
import com.simx.mvvmdatabindingsample.data.entity.User
import com.simx.mvvmdatabindingsample.data.local.AppDatabase
import com.simx.mvvmdatabindingsample.databinding.ActivityMainBinding
import com.simx.mvvmdatabindingsample.main.dialog.AddUserDialogFragment
import com.simx.mvvmdatabindingsample.tools.InjectorTools

class MainActivity : AppCompatActivity(), MainPresenter, AdapterUserItem.OnAdapterUserItemListener {
    override fun onAdapterUserItemClicked(user: User) {
        shoeDialogdelete(user)
    }

    private fun shoeDialogdelete(user: User) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete data")
        builder.setMessage("Are you sure want to deleting data ${user.firstName}")
        builder.setPositiveButton("YES") { dialog, which ->
            dialog.dismiss()
            mainViewModel.deleteUserOne(user)
        }
        builder.setNegativeButton("No") { dialog, which -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

    override fun showToas() {
        val dialog = AddUserDialogFragment()
        dialog.show(supportFragmentManager,"")
    }

    override fun updateAdapter(it: List<User>?) {
        Log.e("","data ${it.toString()}")
        adapterUserItem.setUsers(it)
    }

    private lateinit var adapterUserItem: AdapterUserItem
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mainVmFactory: MainViewModelFactory = InjectorTools.provideMainViewModel(this,AppDatabase.getInstance(this).userDao())
        mainViewModel = ViewModelProviders.of(this,mainVmFactory).get(MainViewModel::class.java)
        binding.mainVm  = mainViewModel
        adapterUserItem  = AdapterUserItem(listOf(), this)
        mainViewModel.showToas()
        binding.mainContent.rcvMain.setHasFixedSize(true)
        binding.mainContent.rcvMain.layoutManager = GridLayoutManager(this,4)
        binding.mainContent.rcvMain.itemAnimator = DefaultItemAnimator()
        binding.mainContent.rcvMain.adapter = adapterUserItem
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
