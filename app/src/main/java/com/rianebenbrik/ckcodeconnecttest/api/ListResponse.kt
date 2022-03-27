package com.rianebenbrik.ckcodeconnecttest.api

import User
import com.google.gson.annotations.SerializedName

class ListResponse {

    @SerializedName("data")
    public val listuser: ArrayList<User>? = null

}