package com.daniel.core.utils

import android.os.Build



object DeviceUtils {
    fun getAndroidVersion(): String {
        val release = Build.VERSION.RELEASE
        val sdkVersion = Build.VERSION.SDK_INT
        return "AndroidVersion: $sdkVersion ($release)"
    }

    fun getDeviceManufacturer(): String = Build.MANUFACTURER

    fun getDeviceModel(): String = Build.MODEL
}