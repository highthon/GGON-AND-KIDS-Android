package com.example.jjol

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE

class Jjol: Application() {
    companion object {
        //var prefs: Prefs? = null
       // const val Authorization = "Authorization"
        var token = ""
    }

    override fun onCreate() {
        //prefs = Prefs(applicationContext)
        super.onCreate()
    }
}

//class Prefs(context: Context) {
//    private val prefNm = "mPref"
//    private val prefs = context.getSharedPreferences(prefNm,MODE_PRIVATE)
//
//    var token: String?
//        get() = prefs.getString(Jjol.token, null)
//        set(value) {
//            prefs.edit().putString(Jjol.token, value).apply()
//        }
//}