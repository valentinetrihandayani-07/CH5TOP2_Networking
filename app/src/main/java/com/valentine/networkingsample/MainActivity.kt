package com.valentine.networkingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.valentine.networkingsample.model.GetAllCarResponseItem
import com.valentine.networkingsample.model.RegisterResponseItem
import com.valentine.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
/*    val button = findViewById<Button>(R.id.btnRegister)

    button.setOnClickListener {
        val registerRequest = RegisterRequest(
            email = "testing@gmail.com",
            password = "12345",
            role = "admin"
        )



        CarsApi.retrofitService.registerAdmin(registerRequest).enqueue(object: Callback<RegisterResponseItem>{
            override fun onResponse(
                call: Call<RegisterResponseItem>
        }{
            Log.d("Main Activity", "ini data register => ${response.body()}")
        }
                override fun onFailure(call: Call<RegisterResponseItem>, t:Throwable){

        }
    })

}*/
