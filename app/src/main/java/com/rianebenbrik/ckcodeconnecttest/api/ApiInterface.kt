

import com.rianebenbrik.ckcodeconnecttest.api.ListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("app-id:"+appid)
    @GET("user")
    fun getUsers() : Call<ListResponse>

    companion object {
        const val appid = "623e2ae08615fdcb32f3fe8f"
    }
}