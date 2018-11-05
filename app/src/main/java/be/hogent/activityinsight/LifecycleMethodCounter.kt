package be.hogent.activityinsight

import android.databinding.BaseObservable
import android.databinding.Bindable
import java.io.Serializable

/**
 * Class that contains all the counters of the life cycle methods.
 *
 * Attributes are private so they can only be incremented, not changed directly (encapsulation)
 */
class LifecycleMethodCounter : Serializable, BaseObservable() {

    @get:Bindable
    var onCreate: Int = 0
        private set

    @get:Bindable
    var onStart: Int = 0
        private set

    @get:Bindable
    var onResume: Int = 0
        private set

    @get:Bindable
    var onRestart: Int = 0
        private set

    @get:Bindable
    var onPause: Int = 0
        private set

    @get:Bindable
    var onStop: Int = 0
        private set

    @get:Bindable
    var onDestroy: Int = 0
        private set

    fun onDestroyCalled() {
        onDestroy++
        notifyChange()
    }

    fun onStopCalled() {
        onStop++
        notifyChange()
    }

    fun onPauseCalled() {
        onPause++
        notifyChange()
    }

    fun onRestartCalled() {
        onRestart++
        notifyChange()
    }

    fun onResumeCalled() {
        onResume++
        notifyChange()
    }

    fun onStartCalled() {
        onStart++
        notifyChange()
    }

    fun onCreateCalled() {
        onCreate++
        notifyChange()
    }
}
