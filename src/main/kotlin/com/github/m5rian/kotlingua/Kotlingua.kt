package com.github.m5rian.kotlingua

import java.io.InputStream
import java.util.*

object Kotlingua {
    private var directory: String = ""
    lateinit var defaultLang: Lang
    val languages: MutableMap<Lang, Properties> = mutableMapOf()

    fun defaultLangIsSet() = this::defaultLang.isInitialized

    fun loadLanguages() {
        Lang.values().forEach {
            val inputStream: InputStream = Kotlingua.javaClass.classLoader.getResourceAsStream("$directory${it.iso}.properties") ?: return@forEach
            val file = Properties()
            file.load(inputStream)
            languages[it] = file
        }
    }

    fun getLanguageByIso(isoCode: String): Lang? {
        return Lang.values().find { it.iso == isoCode }
    }

}

fun kotlingua(kotlingua: Kotlingua.() -> Unit) = Kotlingua.apply(kotlingua)