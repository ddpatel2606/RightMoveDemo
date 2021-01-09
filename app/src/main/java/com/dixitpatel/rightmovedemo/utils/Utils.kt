package com.dixitpatel.rightmovedemo.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import kotlin.jvm.JvmOverloads
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.lang.Exception
import java.text.NumberFormat
import java.util.*

/**
 * Common utils methods
 */
class Utils
{
    companion object {

        fun isNetworkAvailable(context: Context): Boolean
        {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            var isNetworkAvail = false
            try {
                val n = cm?.activeNetwork
                    val nc = cm?.getNetworkCapabilities(n)
                    isNetworkAvail = nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    return isNetworkAvail
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return isNetworkAvail
        }

        fun hideKeyboard(activity: Activity, flags: Int) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val viewWithFocus = activity.currentFocus
            val windowToken = viewWithFocus?.windowToken
            if (windowToken != null) {
                imm.hideSoftInputFromWindow(windowToken, flags)
            }
        }

        fun getLocalFromISO(isoCode: String): Locale {
            var toReturn: Locale? = null
            for (locale in NumberFormat.getAvailableLocales()) {
                val code: String = NumberFormat.getCurrencyInstance(locale).currency.currencyCode
                if (isoCode == code) {
                    toReturn = locale
                    break
                }
            }
            return toReturn!!
        }

        @JvmOverloads
        fun hideKeyboard(fragment: Fragment, flags: Int = InputMethodManager.HIDE_NOT_ALWAYS) {
            val activity: Activity? = fragment.activity
            if (activity != null) {
                hideKeyboard(activity, flags)
            }
        }

        fun showSoftKeyboard(me: Activity, edt: EditText?) {
            try {
                val imm = me.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(edt, InputMethodManager.SHOW_IMPLICIT)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}