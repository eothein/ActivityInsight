package be.equality.activityinsight

import java.io.Serializable

/**
 * Data class which contains all the counters of the life cycle methods.
 */
data class LifecycleMethodCounter(var onCreate : Int, var onStart : Int, var onResume : Int,
                                  var onRestart : Int, var onPause: Int, var onStop: Int,
                                  var onDestroy : Int) : Serializable {
}