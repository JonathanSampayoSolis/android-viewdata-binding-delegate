package com.sampacodes.viewdatabindingdelegate.presentation.viewBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sampacodes.viewdatabindingdelegate.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private lateinit var binding: FragmentViewBindingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentViewBindingBinding.inflate(inflater, container, false).let {
        binding = it
        binding.root
    }

}