package com.valentine.networkingsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.valentine.networkingsample.R
import com.valentine.networkingsample.databinding.FragmentDetailBinding
import com.valentine.networkingsample.model.GetAllCarResponseItem
import java.text.NumberFormat
import java.util.*


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getParcelable<GetAllCarResponseItem>("car")

        val dec = NumberFormat.getNumberInstance(Locale.US)
        val price = dec.format(data?.price)
        binding.apply {
            txtName.text = data?.name
            txtCategory.text = getString(R.string.category, data?.category)
            txtPrice.text = getString(R.string.price, price)
            Glide.with(view.context).load(data?.image).into(imgCar)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}