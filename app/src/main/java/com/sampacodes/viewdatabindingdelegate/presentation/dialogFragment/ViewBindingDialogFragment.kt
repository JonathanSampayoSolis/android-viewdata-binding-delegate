package com.sampacodes.viewdatabindingdelegate.presentation.dialogFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sampacodes.viewdatabindingdelegate.arch.presentation.viewBinding
import com.sampacodes.viewdatabindingdelegate.databinding.DialogFragmentViewBindingBinding

class ViewBindingDialogFragment : DialogFragment() {

    private val binding by viewBinding<DialogFragmentViewBindingBinding>()

    companion object {

        fun newInstance(): ViewBindingDialogFragment {
            val args = Bundle()

            val fragment = ViewBindingDialogFragment ()
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