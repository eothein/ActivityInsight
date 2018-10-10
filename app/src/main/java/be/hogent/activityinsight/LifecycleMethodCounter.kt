package be.hogent.activityinsight

import java.io.Serializable

/**
 * Class that contains all the counters of the life cycle methods.
 *
 * Attributes are private so they can only be incremented, not changed directly (encapsulation)
 */
class LifecycleMethodCounter : Serializable {
    var onCreate: Int = 0
        private set
    var onStart: Int = 0
        private set
    var onResume: Int = 0
        private set
    var onRestart: Int = 0
        private set
    var onPause: Int = 0
        private set
    var onStop: Int = 0
        private set
    var onDestroy: Int = 0
        private set

    fun onDestroyCalled() {
        onDestroy++
    }

    fun onStopCalled() {
        onStop++
    }

    fun onPauseCalled() {
        onPause++
    }

    fun onRestartCalled() {
        onRestart++
    }

    fun onResumeCalled() {
        onResume++
    }

    fun onStartCalled() {
        onStart++
    }

    fun onCreateCalled() {
        onCreate++
    }
}
