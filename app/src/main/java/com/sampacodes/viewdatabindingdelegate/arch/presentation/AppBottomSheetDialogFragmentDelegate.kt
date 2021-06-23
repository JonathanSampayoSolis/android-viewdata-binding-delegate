package com.sampacodes.viewdatabindingdelegate.arch.presentation

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> BottomSheetDialogFragment.viewBinding() =
    AppBottomSheetDialogFragmentDelegate(T::class.java)

class AppBottomSheetDialogFragmentDelegate<T : ViewBinding>(
    bindingClass: Class<T>
) : ReadOnlyProperty<BottomSheetDialogFragment, T> {

    private var binding: T? = null

    private val inflateMethod by lazy {
        bindingClass.getMethod("inflate", LayoutInflater::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: BottomSheetDialogFragment, property: KProperty<*>): T {
        // if exist a binding reference return
        binding?.let { return it }

        // add lifecycle callback -> onDestroy() remove binding
        thisRef.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {

            @Suppress("unused")
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                binding = null
            }

        })

        val invoke = inflateMethod.invoke(null, LayoutInflater.from(thisRef.context)) as T
        return invoke.also { binding -> this.binding = binding }
    }

}