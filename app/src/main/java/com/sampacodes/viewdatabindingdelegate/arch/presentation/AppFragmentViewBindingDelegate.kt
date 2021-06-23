package com.sampacodes.viewdatabindingdelegate.arch.presentation

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    AppFragmentViewBindingDelegate(T::class.java, this)

class AppFragmentViewBindingDelegate<T : ViewBinding>(
    bindingClass: Class<T>,
    private val fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    private val bindMethod by lazy {
        bindingClass.getMethod("bind", View::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        // if exist a binding reference return
        binding?.let { return it }

        // add lifecycle callback -> onDestroy() remove binding
        fragment.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {

            @Suppress("unused")
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                binding = null
            }

        })

        // bind binding given an already inflated view
        val invoke = bindMethod.invoke(null, thisRef.requireView()) as T
        return invoke.also { binding -> this.binding = binding }
    }

}