package com.valentine.networkingsample.network


import com.valentine.networkingsample.model.GetAllCarResponseItem
import com.valentine.networkingsample.model.RegisterResponseItem
import com.valentine.networkingsample.request.RegisterRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

private val logging: HttpLoggingInterceptor
    get() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
private val okhttpClient = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()


interface ApiService {

    @GET("admin/car")
    fun allCar(): Call<List<GetAllCarResponseItem>>

    @POST("admin/auth/register")
    fun registerBody(@Body registerRequest: RegisterRequest): Call<RegisterResponseItem>

    @GET(EndPoint.ListCar.GET_LIST_CAR)
    fun getAllCar(): Call<List<GetAllCarResponseItem>>

}


object ApiClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(EndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(ApiService::class.java)
    }

}


object EndPoint {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com"

    object ListCar {
        const val GET_LIST_CAR = "/admin/car"
    }
}
