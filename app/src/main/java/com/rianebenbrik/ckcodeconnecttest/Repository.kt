package com.rianebenbrik.ckcodeconnecttest

import User
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rianebenbrik.ckcodeconnecttest.api.ListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun fetchAllUsers(): MutableLiveData<ArrayList<User>?> {
        val data = MutableLiveData<ArrayList<User>?>()
        val apiInterface = APIHelper.getApi().getUsers()
            apiInterface.enqueue(object : Callback<ListResponse> {

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                data.value = null
                Log.d("failed ", ""+t.message)
            }

            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res.listuser
                    // Checking the results
                    Log.d("successed ", data.value.toString())
                } else {
                    data.value = null
                }
            }
        })
        return data
    }
}