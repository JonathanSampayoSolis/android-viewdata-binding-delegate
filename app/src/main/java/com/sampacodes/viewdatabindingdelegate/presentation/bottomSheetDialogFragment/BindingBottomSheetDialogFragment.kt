package com.sampacodes.viewdatabindingdelegate.presentation.bottomSheetDialogFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sampacodes.viewdatabindingdelegate.arch.presentation.viewBinding
import com.sampacodes.viewdatabindingdelegate.databinding.BottomSheetViewBindingBinding

class BindingBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private val binding by viewBinding<BottomSheetViewBindingBinding>()

    companion object {

        fun newInstance(): BindingBottomSheetDialogFragment{
            val args = Bundle()

            val fragment = BindingBottomSheetDialogFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

}