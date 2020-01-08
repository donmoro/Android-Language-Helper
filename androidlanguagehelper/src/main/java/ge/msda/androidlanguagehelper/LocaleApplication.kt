package ge.msda.androidlanguagehelper

import android.app.Application
import android.content.Context
import android.content.res.Configuration

/**
 * Created by ნიკოლოზ კაციტაძე on 1/08/2020
 */

open class LocaleApplication : Application() {

    private val localeAppDelegate = LocaleHelperApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(localeAppDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeAppDelegate.onConfigurationChanged(this)
    }

}