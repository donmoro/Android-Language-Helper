package ge.msda.androidlanguagehelper

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/03/2020
 */

class LocaleHelperActivityImpl : ILocaleHelperActivity {

    private var locale: Locale = Locale.getDefault()

    override fun setLocale(appCompatActivity: AppCompatActivity, newLocale: Locale) {
        LocaleHelper.setLocale(appCompatActivity, newLocale)
        locale = newLocale
        appCompatActivity.recreate()
    }

    override fun attachBaseContext(newBase: Context): Context {
        return LocaleHelper.onAttach(newBase)
    }

    override fun onPaused() {
        locale = Locale.getDefault()
    }

    override fun onResumed(appCompatActivity: AppCompatActivity) {
        if (locale == Locale.getDefault())
            return
        appCompatActivity.recreate()
    }

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(appCompatActivity: AppCompatActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            appCompatActivity.window.decorView.layoutDirection =
                if (Languages.isInRTL((Locale.getDefault().language)))
                    View.LAYOUT_DIRECTION_RTL
                else
                    View.LAYOUT_DIRECTION_LTR
        }
    }

}