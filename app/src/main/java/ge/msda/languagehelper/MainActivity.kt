package ge.msda.languagehelper

import android.os.Bundle
import android.view.View
import android.widget.TextView
import ge.msda.androidlanguagehelper.Languages
import ge.msda.androidlanguagehelper.LocaleAppCompatActivity

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

class MainActivity : LocaleAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeLanguage(view: View) {
        if (view is TextView) {
            when (view.text) {
                "RUS" -> {
                    updateLocale(Languages.RUSSIAN.locale)
                }
                "ENG" -> {
                    updateLocale(Languages.ENGLISH.locale)
                }
                "GEO" -> {
                    updateLocale(Languages.GEORGIAN.locale)
                }
            }
        }
    }

}