package ge.msda.androidlanguagehelper

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

object LocaleHelper {

    fun onAttach(context: Context): Context {
        PreferenceManager.createInstance(context)
        val locale: Locale = getLocale()
        return setLocale(context, locale)
    }

    fun getLocale(): Locale {
        val language: Languages =
            PreferenceManager.instance?.getLanguageFromPref() ?: throw LocaleException(
                LocaleKeywords.CANT_GET_LANGUAGE
            )
        return language.locale
    }

    fun setLocale(context: Context, locale: Locale): Context {

        PreferenceManager.instance?.saveLanguageInPref(Languages.getLanguage(locale)!!)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, locale)
        } else updateResourcesLegacy(context, locale)

    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, locale: Locale): Context {

        Locale.setDefault(locale)

        val config: Configuration = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        return context.createConfigurationContext(config)

    }

    @SuppressLint("ObsoleteSdkInt")
    @SuppressWarnings("deprecation")
    private fun updateResourcesLegacy(context: Context, locale: Locale): Context {

        Locale.setDefault(locale)

        val resources: Resources = context.resources
        val config: Configuration = resources.configuration
        config.locale = locale

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        resources.updateConfiguration(config, resources.displayMetrics)

        return context

    }

}