package me.dahei.myapplication.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class GsonHelper {
    companion object {
        val instance: Gson by lazy { Gson() }
    }

}