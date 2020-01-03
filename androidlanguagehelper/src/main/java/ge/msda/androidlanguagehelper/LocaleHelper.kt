package ge.msda.androidlanguagehelper

import android.content.Context

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

object LocaleHelper {

    fun onAttach(context: Context) {
        PreferenceManager.createInstance(context)
    }

}