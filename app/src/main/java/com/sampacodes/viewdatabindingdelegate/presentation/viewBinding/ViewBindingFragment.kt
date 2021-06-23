package com.sampacodes.viewdatabindingdelegate.presentation.viewBinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sampacodes.viewdatabindingdelegate.R
import com.sampacodes.viewdatabindingdelegate.arch.presentation.tagClass
import com.sampacodes.viewdatabindingdelegate.arch.presentation.viewBinding
import com.sampacodes.viewdatabindingdelegate.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment(R.layout.fragment_view_binding) {

    private val mTag by tagClass()

    private val binding by viewBinding<FragmentViewBindingBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(requireContext(), mTag, Toast.LENGTH_SHORT).show()
    }

}