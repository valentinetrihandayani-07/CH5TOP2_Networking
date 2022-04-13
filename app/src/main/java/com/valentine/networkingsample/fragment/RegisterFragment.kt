package com.valentine.networkingsample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.valentine.networkingsample.R
import com.valentine.networkingsample.databinding.FragmentRegisterBinding
import com.valentine.networkingsample.model.RegisterResponseItem
import com.valentine.networkingsample.network.ApiClient
import com.valentine.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {

    private var bindingPage: FragmentRegisterBinding? = null
    private val binding get() = bindingPage!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingPage = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val passingData = RegisterRequest(
                email = binding.edtEmail.text.toString(),
                password = binding.edtPassword.text.toString(),
                role = binding.edtRole.text.toString()
            )
            ApiClient.instance.registerBody(passingData).enqueue(object :
                Callback<RegisterResponseItem> {
                override fun onResponse(
                    call: Call<RegisterResponseItem>,
                    response: Response<RegisterResponseItem>
                ) {
                    Log.d("passingData", "Register Body => ${response.body()}")
                }

                override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                }
            })
            findNavController().navigate(
                RegisterFragmentDirections.actionRegisterFragmentToViewRegisterFragment(
                    passingData
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingPage = null
    }

}