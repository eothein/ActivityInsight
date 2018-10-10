package be.equality.activityinsight

import java.io.Serializable

/**
 * Data class which contains all the counters of the life cycle methods.
 */
data class LifecycleMethodCounter(var onCreate: Int = 0,
                                  var onStart: Int = 0,
                                  var onResume: Int = 0,
                                  var onRestart: Int = 0,
                                  var onPause: Int = 0,
                                  var onStop: Int = 0,
                                  var onDestroy: Int = 0) : Serializable
