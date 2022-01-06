package com.github.m5rian.kotlingua

import kotlinx.serialization.Serializable
import java.io.FileNotFoundException

@Serializable(with = LangSerializer::class)
data class Lang(val iso: String, val name: String) {
    suspend fun get(key: String, builder: suspend (ArgumentBuilder) -> Unit = {}): String {
        if (!Kotlingua.registeredLanguages.containsKey(this)) throw FileNotFoundException("The language ${this.name} isn't loaded up")

        var translation: String? = Kotlingua.registeredLanguages[this]?.getProperty(key)
        if (translation == null && Kotlingua.defaultLangIsSet()) translation = Kotlingua.registeredLanguages[Kotlingua.defaultLang]?.getProperty(key)

        val argumentBuilder = ArgumentBuilder()
        builder.invoke(argumentBuilder)
        argumentBuilder.args.forEach { (key, value) -> translation = translation?.replace("{$key}", value.toString()) }

        return translation ?: throw NullPointerException("For the key \"$key\" doesn't exist any translation")
    }
}