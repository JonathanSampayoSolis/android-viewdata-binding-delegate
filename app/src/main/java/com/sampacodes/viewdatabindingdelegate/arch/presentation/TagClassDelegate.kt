package com.sampacodes.viewdatabindingdelegate.arch.presentation

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Suppress("unused")
fun Any.tagClass() = TagClassDelegate()

class TagClassDelegate : ReadOnlyProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return thisRef::class.simpleName ?: ""
    }

}