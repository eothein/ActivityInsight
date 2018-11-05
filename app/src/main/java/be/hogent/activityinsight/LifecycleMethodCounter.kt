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
        notifyPropertyChanged(BR.onDestroy)
    }

    fun onStopCalled() {
        onStop++
        notifyPropertyChanged(BR.onStop)
    }

    fun onPauseCalled() {
        onPause++
        notifyPropertyChanged(BR.onPause)
    }

    fun onRestartCalled() {
        onRestart++
        notifyPropertyChanged(BR.onRestart)
    }

    fun onResumeCalled() {
        onResume++
        notifyPropertyChanged(BR.onResume)
    }

    fun onStartCalled() {
        onStart++
        notifyPropertyChanged(BR.onStart)
    }

    fun onCreateCalled() {
        onCreate++
        notifyPropertyChanged(BR.onCreate)
    }
}
