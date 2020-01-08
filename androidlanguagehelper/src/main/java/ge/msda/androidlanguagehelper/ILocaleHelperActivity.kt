package ge.msda.androidlanguagehelper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * Created by ნიკოლოზ კაციტაძე on 1/08/2020
 */

interface ILocaleHelperActivity {
    fun setLocale(appCompatActivity: AppCompatActivity, newLocale: Locale)
    fun attachBaseContext(newBase: Context): Context
    fun onPaused()
    fun onResumed(appCompatActivity: AppCompatActivity)
    fun onCreate(appCompatActivity: AppCompatActivity)
}