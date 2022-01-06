package com.github.m5rian.kotlingua

import java.io.InputStream
import java.util.*

fun kotlingua(kotlingua: Kotlingua.() -> Unit) = Kotlingua.apply(kotlingua)

object Kotlingua {
    var directory: String = ""
    lateinit var defaultLang: Lang
    val registeredLanguages: MutableMap<Lang, Properties> = mutableMapOf()
    fun defaultLangIsSet() = this::defaultLang.isInitialized

    fun getLanguageByIso(isoCode: String): Lang? = languages.find { it.iso == isoCode }
    fun loadCustomLanguage(language: Lang) = languages.add(language)

    fun loadLanguages() {
        languages.forEach {
            val inputStream: InputStream = Kotlingua.javaClass.classLoader.getResourceAsStream("$directory${it.iso}.properties") ?: return@forEach
            val file = Properties()
            file.load(inputStream)
            registeredLanguages[it] = file
        }
    }

    val languages = mutableListOf<Lang>()

    val AFRIKAANS = Lang("af", "afrikaans").also { languages.add(it) }
    val ALBANIAN = Lang("sq", "albanian").also { languages.add(it) }
    val ARABIC_ALGERIA = Lang("ar_DZ", "arabic algeria").also { languages.add(it) }
    val ARABIC_BAHRAIN = Lang("ar_BH", "arabic bahrain").also { languages.add(it) }
    val ARABIC_EGYPT = Lang("ar_EG", "arabic egypt").also { languages.add(it) }
    val ARABIC_IRAQ = Lang("ar-iq","arabic iraq").also { languages.add(it) }
    val ARABIC_JORDAN = Lang("ar-jo","arabic jordan").also { languages.add(it) }
    val ARABIC_KUWAIT = Lang("ar-kw","arabic kuwait").also { languages.add(it) }
    val ARABIC_LEBANON = Lang("ar-lb","arabic lebanon").also { languages.add(it) }
    val ARABIC_LIBYA = Lang("ar-ly","arabic libya").also { languages.add(it) }
    val ARABIC_MOROCCO = Lang("ar-ma","arabic morocco").also { languages.add(it) }
    val ARABIC_OMAN = Lang("ar-om","arabic oman").also { languages.add(it) }
    val ARABIC_QATAR = Lang("ar-qa","arabic qatar").also { languages.add(it) }
    val ARABIC_SAUDI = Lang("ar-sa","arabic saudi").also { languages.add(it) }
    val ARABIC_SYRIA = Lang("ar-sy","arabic syria").also { languages.add(it) }
    val ARABIC_TUNISIA = Lang("ar-tn","arabic tunisia").also { languages.add(it) }
    val ARABIC_UAE = Lang("ar-ae","arabic uae").also { languages.add(it) }
    val ARABIC_YEMEN = Lang("ar-ye","arabic yemen").also { languages.add(it) }
    val BASQUE = Lang("eu","basque").also { languages.add(it) }
    val BELARUSIAN = Lang("be","belarusian").also { languages.add(it) }
    val BULGARIAN = Lang("bg","bulgarian").also { languages.add(it) }
    val CATALAN = Lang("ca","catalan").also { languages.add(it) }
    val CHINESE_HONG_KONG = Lang("zh_HK","chinese hong kong").also { languages.add(it) }
    val CHINESE_PRC = Lang("zh_CN","chinese prc").also { languages.add(it) }
    val CHINESE_SINGAPORE = Lang("zh_SG","chinese singapore").also { languages.add(it) }
    val CHINESE_TAIWAN = Lang("zh_TW","chinese taiwan").also { languages.add(it) }
    val CROATIAN = Lang("hr","croatian").also { languages.add(it) }
    val CZECH = Lang("cs","czech").also { languages.add(it) }
    val DANISH = Lang("da","danish").also { languages.add(it) }
    val DUTCH_BELGIUM = Lang("nl-be","dutch belgium").also { languages.add(it) }
    val DUTCH_STANDARD = Lang("nl","dutch standard").also { languages.add(it) }
    val ENGLISH = Lang("en","english").also { languages.add(it) }
    val ENGLISH_AUSTRALIA = Lang("en_AU","english australia").also { languages.add(it) }
    val ENGLISH_BELIZE = Lang("en_BZ","english belize").also { languages.add(it) }
    val ENGLISH_CANADA = Lang("en_CA","english canada").also { languages.add(it) }
    val ENGLISH_IRELAND = Lang("en_IE","english ireland").also { languages.add(it) }
    val ENGLISH_JAMAICA = Lang("en_JM","english jamaica").also { languages.add(it) }
    val ENGLISH_NEW_ZEELAND = Lang("en-nz","english new zeeland").also { languages.add(it) }
    val ENGLISH_SOUTH = Lang("en-za","english south").also { languages.add(it) }
    val ENGLISH_TRINIDAD = Lang("en-tt","english trinidad").also { languages.add(it) }
    val ENGLISH_UNITED_KINGDOM = Lang("en_GB","english united kingdom").also { languages.add(it) }
    val ENGLISH_UNITED_STATES = Lang("en_US","english united states").also { languages.add(it) }
    val ESTONIAN = Lang("et","estonian").also { languages.add(it) }
    val FAEROESE = Lang("fo","faeroese").also { languages.add(it) }
    val FARSI = Lang("fa","farsi").also { languages.add(it) }
    val FINNISH = Lang("fi","finnish").also { languages.add(it) }
    val FRENCH_BELGIUM = Lang("fr-be","french belgium").also { languages.add(it) }
    val FRENCH_CANADA = Lang("fr-ca","french canada").also { languages.add(it) }
    val FRENCH_LUXEMBOURG = Lang("fr-lu","french luxembourg").also { languages.add(it) }
    val FRENCH_STANDARD = Lang("fr","french standard").also { languages.add(it) }
    val FRENCH_SWITZERLAND = Lang("fr-ch","french switzerland").also { languages.add(it) }
    val GAELIC_SCOTLAND = Lang("gd","gaelic scotland").also { languages.add(it) }
    val GERMAN_AUSTRIA = Lang("de_AT","german austria").also { languages.add(it) }
    val GERMAN_LIECHTENSTEIN = Lang("de_LI","german liechtenstein").also { languages.add(it) }
    val GERMAN_LUXEMBOURG = Lang("de_LU","german luxembourg").also { languages.add(it) }
    val GERMAN_STANDARD = Lang("de","german standard").also { languages.add(it) }
    val GERMAN_SWITZERLAND = Lang("de-ch","german switzerland").also { languages.add(it) }
    val GREEK = Lang("el","greek").also { languages.add(it) }
    val HEBREW = Lang("he","hebrew").also { languages.add(it) }
    val HINDI = Lang("hi","hindi").also { languages.add(it) }
    val HUNGARIAN = Lang("hu","hungarian").also { languages.add(it) }
    val ICELANDIC = Lang("is","icelandic").also { languages.add(it) }
    val INDONESIAN = Lang("id","indonesian").also { languages.add(it) }
    val IRISH = Lang("ga","irish").also { languages.add(it) }
    val ITALIAN_STANDARD = Lang("it","italian standard").also { languages.add(it) }
    val ITALIAN_SWITZERLAND = Lang("it-ch","italian switzerland").also { languages.add(it) }
    val JAPANESE = Lang("ja","japanese").also { languages.add(it) }
    val KOREAN = Lang("ko","korean").also { languages.add(it) }
    val KOREAN_JOHAB = Lang("ko","korean johab").also { languages.add(it) }
    val KURDISH = Lang("ku","kurdish").also { languages.add(it) }
    val LATVIAN = Lang("lv","latvian").also { languages.add(it) }
    val LITHUANIAN = Lang("lt","lithuanian").also { languages.add(it) }
    val MACEDONIAN_FYROM = Lang("mk","macedonian fyrom").also { languages.add(it) }
    val MALAYALAM = Lang("ml","malayalam").also { languages.add(it) }
    val MALAYSIAN = Lang("ms","malaysian").also { languages.add(it) }
    val MALTESE = Lang("mt","maltese").also { languages.add(it) }
    val NORWEGIAN = Lang("no","norwegian").also { languages.add(it) }
    val NORWEGIAN_BOKMAL = Lang("nb","norwegian bokmal").also { languages.add(it) }
    val NORWEGIAN_NYNORSK = Lang("nn","norwegian nynorsk").also { languages.add(it) }
    val POLISH = Lang("pl","polish").also { languages.add(it) }
    val PORTUGUESE_BRAZIL = Lang("pt-br","portuguese brazil").also { languages.add(it) }
    val PORTUGUESE_PORTUGAL = Lang("pt","portuguese portugal").also { languages.add(it) }
    val PUNJABI = Lang("pa","punjabi").also { languages.add(it) }
    val RHAETO_ROMANIC = Lang("rm","rhaeto romanic").also { languages.add(it) }
    val ROMANIAN = Lang("ro","romanian").also { languages.add(it) }
    val ROMANIAN_REPUBLIC_OF_MOLDOVA = Lang("ro-md","romanian republic of moldova").also { languages.add(it) }
    val RUSSIAN = Lang("ru","russian").also { languages.add(it) }
    val RUSSIAN_REPUBLIC_OF_MOLDOVA = Lang("ru-md","russian republic of moldova").also { languages.add(it) }
    val SERBIAN = Lang("sr","serbian").also { languages.add(it) }
    val SLOVAK = Lang("sk","slovak").also { languages.add(it) }
    val SLOVENIAN = Lang("sl","slovenian").also { languages.add(it) }
    val SORBIAN = Lang("sb","sorbian").also { languages.add(it) }
    val SPANISH_ARGENTINA = Lang("es-ar","spanish argentina").also { languages.add(it) }
    val SPANISH_BOLIVIA = Lang("es-bo","spanish bolivia").also { languages.add(it) }
    val SPANISH_CHILE = Lang("es-cl","spanish chile").also { languages.add(it) }
    val SPANISH_COLOMBIA = Lang("es-co","spanish colombia").also { languages.add(it) }
    val SPANISH_COSTA = Lang("es-cr","spanish costa").also { languages.add(it) }
    val SPANISH_DOMINICAN_REPUBLIC = Lang("es-do","spanish dominican republic").also { languages.add(it) }
    val SPANISH_ECUADOR = Lang("es-ec","spanish ecuador").also { languages.add(it) }
    val SPANISH_EL = Lang("es-sv","spanish el").also { languages.add(it) }
    val SPANISH_GUATEMALA = Lang("es-gt","spanish guatemala").also { languages.add(it) }
    val SPANISH_HONDURAS = Lang("es-hn","spanish honduras").also { languages.add(it) }
    val SPANISH_MEXICO = Lang("es-mx","spanish mexico").also { languages.add(it) }
    val SPANISH_NICARAGUA = Lang("es-ni","spanish nicaragua").also { languages.add(it) }
    val SPANISH_PANAMA = Lang("es-pa","spanish panama").also { languages.add(it) }
    val SPANISH_PARAGUAY = Lang("es-py","spanish paraguay").also { languages.add(it) }
    val SPANISH_PERU = Lang("es-pe","spanish peru").also { languages.add(it) }
    val SPANISH_PUERTO_RICO = Lang("es-pr","spanish puerto rico").also { languages.add(it) }
    val SPANISH_SPAIN = Lang("es","spanish spain").also { languages.add(it) }
    val SPANISH_URUGUAY = Lang("es-uy","spanish uruguay").also { languages.add(it) }
    val SPANISH_VENEZUELA = Lang("es-ve","spanish venezuela").also { languages.add(it) }
    val SWEDISH = Lang("sv","swedish").also { languages.add(it) }
    val SWEDISH_FINLAND = Lang("sv-fi","swedish finland").also { languages.add(it) }
    val THAI = Lang("th","thai").also { languages.add(it) }
    val TSONGA = Lang("ts","tsonga").also { languages.add(it) }
    val TSWANA = Lang("tn","tswana").also { languages.add(it) }
    val TURKISH = Lang("tr","turkish").also { languages.add(it) }
    val UKRAINIAN = Lang("uk","ukrainian").also { languages.add(it) }
    val URDU = Lang("ur","urdu").also { languages.add(it) }
    val VENDA = Lang("ve","venda").also { languages.add(it) }
    val VIETNAMESE = Lang("vi","vietnamese").also { languages.add(it) }
    val WELSH = Lang("cy","welsh").also { languages.add(it) }
    val XHOSA = Lang("xh","xhosa").also { languages.add(it) }
    val YIDDISH = Lang("ji","yiddish").also { languages.add(it) }
    val ZULU = Lang("zu", "zulu").also { languages.add(it) }

}