package com.taylorm.s169382

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import firebase.com.protolitewrapper.BuildConfig
import timber.log.Timber

/*
Application class for the app. Extends the Android Application class.
 */

@HiltAndroidApp
class CareHomeApplication : Application() {

    /*
    Overrides the onCreate method of the Android Application class.
    Performs initialisation tasks for the app.
     */
    override fun onCreate() {
        super.onCreate()

        /*
        Check if the app is running in debug mode.
         */
        if (BuildConfig.DEBUG) {

            /*
            If the app is running in debug mode, initialise Timber for logging.
             */
            Timber.plant(Timber.DebugTree())
        }
    }
}