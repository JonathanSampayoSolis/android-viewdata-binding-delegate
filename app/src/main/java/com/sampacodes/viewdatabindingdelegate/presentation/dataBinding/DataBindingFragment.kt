package com.sampacodes.viewdatabindingdelegate.presentation.dataBinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sampacodes.viewdatabindingdelegate.R
import com.sampacodes.viewdatabindingdelegate.arch.presentation.viewBinding
import com.sampacodes.viewdatabindingdelegate.databinding.FragmentDataBindingBinding

class DataBindingFragment : Fragment(R.layout.fragment_data_binding) {

    private val binding by viewBinding<FragmentDataBindingBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.subtitle = "Foo"
    }

}