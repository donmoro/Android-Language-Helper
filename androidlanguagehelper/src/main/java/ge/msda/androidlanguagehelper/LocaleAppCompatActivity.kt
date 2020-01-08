package ge.msda.androidlanguagehelper

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/08/2020
 */

open class LocaleAppCompatActivity : AppCompatActivity() {

    private val localeDelegate = LocaleHelperActivityImpl()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(localeDelegate.attachBaseContext(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localeDelegate.onCreate(this)
    }

    override fun onResume() {
        super.onResume()
        localeDelegate.onResumed(this)
    }

    override fun onPause() {
        super.onPause()
        localeDelegate.onPaused()
    }

    open fun updateLocale(locale: Locale) {
        localeDelegate.setLocale(this, locale)
    }

}