package com.sampacodes.viewdatabindingdelegate.arch.presentation

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Suppress("unused")
inline fun <reified T : ViewBinding> AppActivity.viewBinding() =
    AppActivityViewBindingDelegate(T::class.java)

class AppActivityViewBindingDelegate<T : ViewBinding>(
    bindingClass: Class<T>
) : ReadOnlyProperty<AppActivity, T> {

    private var binding: T? = null

    private val inflateMethod by lazy {
        bindingClass.getMethod("inflate", LayoutInflater::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: AppActivity, property: KProperty<*>): T {
        // if exist a binding reference return
        binding?.let { return it }

        // add lifecycle callback -> onDestroy() remove binding
        thisRef.lifecycle.addObserver(object : LifecycleObserver {

            @Suppress("unused")
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                binding = null
            }

        })

        val invoke = inflateMethod.invoke(null, LayoutInflater.from(thisRef)) as T

        thisRef.setContentView(invoke.root)

        return invoke.also { binding -> this.binding = binding }
    }

}