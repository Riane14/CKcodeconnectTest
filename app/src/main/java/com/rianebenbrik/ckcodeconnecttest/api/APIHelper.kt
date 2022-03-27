import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIHelper {

    companion object{

        fun getApi(): ApiInterface{

             val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dummyapi.io/data/v1/")
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }


}