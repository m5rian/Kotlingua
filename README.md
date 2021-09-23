# 🌍 Kotlingua

This little library helps you to make multi-language applications.

## 🔧 Setup

Before you code something you need to create the language files. For this you need to use javas `.properties` files, which
have a key - value structure. Here is an example of an english file.

```properties
startup=Hello World!
```

#### 📁 Where to locate the file?

You can locate it anywhere in your `resources` folder. If you create a subfolder (for example `resources/languages/`) you
need to specify that in the `Kotlingua` object. [More on this here](#-custom-path)

#### 🔖 How to name the file?

Take a look at the `Lang` enum. There you can find all languages, which all have an iso-code.  
If you created a file for an English (british) translation search for the entry first. In this case it would
be `Lang.ENGLISH_UNITED_KINGDOM`. As an argument you see the iso-code: `en_GB`. Copy it and name your file like that. That's
it.

## 🗝 Getting translations

Before using any strings make sure to load your current languages!

```kotlin
fun main(ags: Array<String>) {
    Kotlingua.loadLanguages()
}
```

Now to get a string get your language from the enum and call the `get` method.

```kotlin
fun main(ags: Array<String>) {
    Kotlingua.loadLanguages()

    val startupString = Lang.ENGLISH_UNITED_KINGDOM.get("startup")
    println(startupString)
}
```

Console output:

```
Hello World!
```

## 🎡 "Advanced setup"

Using the builder you can set up more detailed things:

#### 📁 Custom path

When adding custom folders in the `resource` directory you need to specify this as well. In the example below the new folder
of the language files is in `resources/languages/`.

```kotlin
fun main(ags: Array<String>) {
    kotlingua {
        directory = "languages/"
    }.also { it.loadLanguages() }
}
```

#### 🚩 Default language

If you're trying to get a string from a language, where the string key doesn't it normally throws a `NullPointerException`.
With a default language you can prevent those exceptions by adding a default language. So if the key you're looking for
doesn't exist for the specified language, Kotlingua uses the value from the specified default language. **Note that this can
be null too** if the key doesn't exist there as well.

```kotlin
    fun main(ags: Array<String>) {
    kotlingua {
        defaultLang = Lang.ENGLISH_UNITED_KINGDOM
    }.also { it.loadLanguages() }
}
```


