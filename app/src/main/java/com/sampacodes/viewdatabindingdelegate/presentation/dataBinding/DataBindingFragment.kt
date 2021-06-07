package com.sampacodes.viewdatabindingdelegate.presentation.dataBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sampacodes.viewdatabindingdelegate.databinding.FragmentDataBindingBinding

class DataBindingFragment : Fragment() {

    private lateinit var binding: FragmentDataBindingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDataBindingBinding.inflate(inflater, container, false).let {
        binding = it
        binding.root
    }

}