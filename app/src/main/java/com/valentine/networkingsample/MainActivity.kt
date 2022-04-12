package com.valentine.networkingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valentine.networkingsample.model.GetAllCarResponseItem
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*        CarsApi.retrofitService.getAllCar().enqueue(object : Callback<List<GetAllCarResponseItem>>{
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                val result = GetAllCarResponseItem

            }

            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                //do something if failure
            }

        }

        )*/
    }
}
