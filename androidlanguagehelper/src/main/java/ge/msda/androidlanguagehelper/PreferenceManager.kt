package ge.msda.androidlanguagehelper

import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

class PreferenceManager private constructor(private val context: Context) {

    companion object {

        const val LANGUAGE_CODE: String = "LANGUAGE_CODE"
        const val COUNTRY_CODE: String = "COUNTRY_CODE"

        var instance: PreferenceManager? = null

        fun createInstance(context: Context) {
            instance = PreferenceManager(context)
        }

    }

    private fun getPreferences(): SharedPreferences {
        return context.getSharedPreferences(
            PreferenceManager::class.java.name,
            Context.MODE_PRIVATE
        )
    }

    fun saveLanguageInPref(language: Languages) {

        getPreferences()
            .edit()
            .putString(LANGUAGE_CODE, language.locale.language)
            .putString(COUNTRY_CODE, language.locale.country)
            .apply()

    }

    fun getLanguageFromPref(): Languages? {

        val lang: String? = getPreferences()
            .getString(LANGUAGE_CODE, Locale.getDefault().language)

        val country: String? = getPreferences()
            .getString(COUNTRY_CODE, Locale.getDefault().country)

        return Languages.getLanguage(Locale(lang!!, country!!))

    }

}