package com.rianebenbrik.ckcodeconnecttest

import User
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rianebenbrik.ckcodeconnecttest.databinding.ActivityUserDetailsBinding


class UserDetails : AppCompatActivity() {

    lateinit var user : User
    private lateinit var binding: ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            user = (intent.getSerializableExtra("user") as User?)!!
        }

        filldetails(user)
    }

    fun filldetails(user: User) {
        binding.firstname.setText(getString(R.string.firstname,user.firstName))
        binding.lastname.text= getString(R.string.lastename,user.lastName)
        binding.title.text=getString(R.string.title,user.title)
        Glide.with(this.applicationContext)
             .load(user.picture)
             .error(com.rianebenbrik.ckcodeconnecttest.R.drawable.ic_baseline_account_box_24)
             .into(binding.picture)
    }
}