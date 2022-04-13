package com.valentine.networkingsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.valentine.networkingsample.databinding.FragmentViewRegisterBinding

class ViewRegisterFragment : Fragment() {
    private var bindingPage: FragmentViewRegisterBinding? = null
    private val binding get() = bindingPage!!
    private val arguments: ViewRegisterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingPage = FragmentViewRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtEmail.text = arguments.registerUser.email
        binding.txtPassword.text = arguments.registerUser.password
        binding.txtRole.text = arguments.registerUser.role
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingPage = null
    }
}