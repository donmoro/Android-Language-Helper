package ge.msda.androidlanguagehelper

import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

enum class Language(val locale: Locale) {

    GEORGIAN(Locale("ka", "GE")),

    ENGLISH(Locale.ENGLISH),

    RUSSIAN(Locale("ru", "RU")),

    TURKISH(Locale("tr", "TR")),

    ROMANIAN(Locale("ro", "RO")),

    POLISH(Locale("pl", "PL")),

    HINDI(Locale("hi", "IN")),

    URDU(Locale("ur", "IN"));

    companion object {

        val RTL: Set<String> = hashSetOf(
            "ar",
            "dv",
            "fa",
            "ha",
            "he",
            "iw",
            "ji",
            "ps",
            "sd",
            "ug",
            "ur",
            "yi"
        )

        fun getLanguage(locale: Locale): Language? {
            values()
                .find {
                    if (it.locale.language == locale.language && it.locale.country == locale.country)
                        return it
                    return null
                }
            return null
        }

        fun isInRTL(languageCode: String): Boolean {
            return RTL.contains(languageCode)
        }

    }

}