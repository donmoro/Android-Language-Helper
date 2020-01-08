package ge.msda.androidlanguagehelper

import android.content.Context

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

class LocaleHelperApplicationDelegate {

    fun attachBaseContext(base: Context): Context {
        return LocaleHelper.onAttach(base)
    }

    fun onConfigurationChanged(context: Context) {
        LocaleHelper.onAttach(context)
    }

}