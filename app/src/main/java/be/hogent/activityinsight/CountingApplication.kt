package be.hogent.activityinsight

import android.app.Application
import timber.log.Timber

class CountingApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}