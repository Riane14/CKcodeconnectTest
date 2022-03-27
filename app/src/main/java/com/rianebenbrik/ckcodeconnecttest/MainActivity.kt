package com.rianebenbrik.ckcodeconnecttest

import User
import UserAdapter
import UserViewmodel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rianebenbrik.ckcodeconnecttest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), UserAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: UserViewmodel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myrecycle : RecyclerView = binding.myrecycleview
        myrecycle.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(ArrayList<User>(),this.applicationContext,this)
        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        myrecycle.setLayoutManager(mLayoutManager)
        myrecycle.let{ it.adapter=adapter}


        viewModel= ViewModelProvider(this)[UserViewmodel::class.java]
        viewModel.fetchAllusers()
        viewModel.usersListLiveData?.observe(this, Observer {
            if (it!=null){
                adapter.setData(it as ArrayList<User>)
            }else{
                Log.d("failed", "Something went wrong")
            }
        })

    }

    override fun onItemClicked(user: User) {
        val intent = Intent(this,UserDetails::class.java)
        val bundle = Bundle()
        bundle.putSerializable("user", user)
        intent.putExtras(bundle)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.applicationContext.startActivity(intent)
    }


}