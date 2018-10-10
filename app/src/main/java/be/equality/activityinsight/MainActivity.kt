package be.equality.activityinsight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var counter: LifecycleMethodCounter = LifecycleMethodCounter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //If savedInstanceState is not null, getSerializable will be called
        //Otherwise this line is skipped
        savedInstanceState?.let {
           counter = it.getSerializable(COUNTER) as LifecycleMethodCounter
        }

        counter.onCreateCalled()
        textViewOnCreateNumber.text = "${counter.onCreate}"
        Log.d(TAG, "onCreate called for the ${counter.onCreate} time")
    }

    override fun onStart() {
        super.onStart()
        counter.onStartCalled()
        textViewOnStartNumber.text = "${counter.onStart}"
        Log.d(TAG, "onStart called for the ${counter.onCreate} time")

    }

    override fun onResume() {
        super.onResume()
        counter.onResumeCalled()
        textViewOnResumeNumber.text = "${counter.onResume}"
        Log.d(TAG, "onResume called for the ${counter.onCreate} time")
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestartCalled()
        textViewOnRestartNumber.text = "${counter.onRestart}"
        Log.d(TAG, "onRestart called for the ${counter.onCreate} time")
    }

    override fun onPause() {
        super.onPause()
        counter.onPauseCalled()
        textViewOnPausetNumber.text = "${counter.onPause}"

        Log.d(TAG, "onPause called for the ${counter.onCreate} time")
    }

    override fun onStop() {
        super.onStop()
        counter.onStopCalled()
        textViewOnStoptNumber.text = "${counter.onStop}"
        Log.d(TAG, "onStop called for the ${counter.onCreate} time")
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroyCalled()
        textViewOnDestroyNumber.text = "${counter.onDestroy}"
        Log.d(TAG, "onDestroy called for the ${counter.onCreate} time")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(COUNTER, counter)
    }

    companion object {
        private const val COUNTER = "counter"
        private const val TAG = "MainActivity"
    }


}
