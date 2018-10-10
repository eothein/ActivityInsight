package be.equality.activityinsight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.counter_table.*

/**
 * This class is a superclass for activities that count and display their lifecycle method calls
 */
abstract class CountingActivity : AppCompatActivity() {
    private var counter: LifecycleMethodCounter = LifecycleMethodCounter()

    /**
     * The TAG that will be used for logging
     */
    abstract val TAG : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        //If savedInstanceState is not null, getSerializable will be called
        //Otherwise this line is skipped
        savedInstanceState?.let {
            counter = it.getSerializable(COUNTER) as LifecycleMethodCounter
        }

        counter.onCreateCalled()
        textViewOnCreateNumber.text = "${counter.onCreate}"
        Log.i(TAG, "onCreate called ${counter.onCreate} times")
    }

    /**
     * We can't set a correct layout in this CountingActivity, as each subclass has its own layout.
     * We let these subclasses implement this method, which returns the correct layout.
     * This way we can still reuse the onCreate from the superclass
     */
    abstract fun getLayoutId(): Int

    override fun onStart() {
        super.onStart()
        counter.onStartCalled()
        /**
         * When onStart is called we shouldn't just update that text, but all texts
         * After a configuration change all textfields would otherwise be empty instead of displaying 0.
         */
        updateUI()
        Log.i(TAG, "onStart called ${counter.onCreate} times")
    }

    private fun updateUI() {
        textViewOnStartNumber.text = "${counter.onStart}"
        textViewOnResumeNumber.text = "${counter.onResume}"
        textViewOnRestartNumber.text = "${counter.onRestart}"
        textViewOnPauseNumber.text = "${counter.onPause}"
        textViewOnStopNumber.text = "${counter.onStop}"
        textViewOnDestroyNumber.text = "${counter.onDestroy}"
    }

    override fun onResume() {
        super.onResume()
        counter.onResumeCalled()
        textViewOnResumeNumber.text = "${counter.onResume}"
        Log.i(TAG, "onResume called ${counter.onCreate} times")
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestartCalled()
        textViewOnRestartNumber.text = "${counter.onRestart}"
        Log.i(TAG, "onRestart called ${counter.onCreate} times")
    }

    override fun onPause() {
        super.onPause()
        counter.onPauseCalled()
        textViewOnPauseNumber.text = "${counter.onPause}"

        Log.i(TAG, "onPause called ${counter.onCreate} times")
    }

    override fun onStop() {
        super.onStop()
        counter.onStopCalled()
        textViewOnStopNumber.text = "${counter.onStop}"
        Log.i(TAG, "onStop called ${counter.onCreate} times")
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroyCalled()
        textViewOnDestroyNumber.text = "${counter.onDestroy}"
        Log.i(TAG, "onDestroy called ${counter.onCreate} times")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(COUNTER, counter)
    }

    companion object {
        private const val COUNTER = "counter"
    }
}