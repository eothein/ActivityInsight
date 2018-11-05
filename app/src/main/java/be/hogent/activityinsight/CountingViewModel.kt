package be.hogent.activityinsight

import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View

class CountingViewModel : ViewModel() {
    val counter = ObjectMutableLiveData<LifecycleMethodCounter>()
    val secondActivityEvent = SingleLiveEvent<Unit>()
    val backEvent = SingleLiveEvent<Unit>()

    init {
        counter.value = LifecycleMethodCounter()
    }

    fun onSecondActivityButtonClicked(v: View) {
        secondActivityEvent.call()
    }

    fun onBackButtonClicked(v: View) {
        backEvent.call()
    }

    fun onDestroyCalled() {
        counter.value!!.onDestroyCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onDestroy} times")
    }

    fun onStopCalled() {
        counter.value!!.onStopCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onStop} times")
    }

    fun onPauseCalled() {
        counter.value!!.onPauseCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onPause} times")
    }

    fun onRestartCalled() {
        counter.value!!.onRestartCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onRestart} times")
    }

    fun onResumeCalled() {
        counter.value!!.onResumeCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onResume} times")
    }

    fun onStartCalled() {
        counter.value!!.onStartCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onStart} times")
    }

    fun onCreateCalled() {
        counter.value!!.onCreateCalled()
        Log.i(TAG, "onCreate called ${counter.value!!.onCreate} times")
    }

    companion object {
        private const val TAG = "CountingViewModel"
    }
}
