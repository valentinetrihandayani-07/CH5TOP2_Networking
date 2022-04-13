package com.valentine.networkingsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.valentine.networkingsample.databinding.FragmentHomeBinding
import com.valentine.networkingsample.model.GetAllCarResponseItem
import com.valentine.networkingsample.network.ApiClient
import com.valentine.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchAllData()

        binding.facButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRegisterFragment())
        }
    }

    private fun fetchAllData() {
        ApiClient.instance.getAllCar().enqueue(object : Callback<List<GetAllCarResponseItem>> {
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                val body = response.body()
                val code = response.code()

                if (code == 200) {
                    binding.loading.visibility = View.GONE
                    showData(body)
                }
            }

            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                binding.loading.visibility = View.GONE
                Snackbar.make(binding.root, "Terjadi Masalah", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun showData(body: List<GetAllCarResponseItem>?) {
        val adapter = CarAdapter()
        adapter.submitList(body)
        binding.rvCar.adapter = adapter
        binding.rvCar.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}