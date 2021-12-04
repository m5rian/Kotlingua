package com.github.m5rian.kotlingua

class ArgumentBuilder {
    var args = mutableMapOf<String, Any>()
    fun arg(key: String, value: Any) {
        args[key] = value
    }
}