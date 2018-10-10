package be.equality.activityinsight

import java.io.Serializable

/**
 * Data class which contains all the counters of the life cycle methods.
 *
 * Attributes are private so they can only be incremented, not changed directly
 */
class LifecycleMethodCounter(onCreate: Int = 0,
                             onStart: Int = 0,
                             onResume: Int = 0,
                             onRestart: Int = 0,
                             onPause: Int = 0,
                             onStop: Int = 0,
                             onDestroy: Int = 0) : Serializable {
    var onCreate: Int = onCreate
        private set
    var onStart: Int = onStart
        private set
    var onResume: Int = onResume
        private set
    var onRestart: Int = onRestart
        private set
    var onPause: Int = onPause
        private set
    var onStop: Int = onStop
        private set
    var onDestroy: Int = onDestroy
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
