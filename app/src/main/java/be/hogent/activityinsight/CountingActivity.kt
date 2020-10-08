package be.hogent.activityinsight

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import be.hogent.activityinsight.databinding.ActivityOneBinding


/**
 * This class is a superclass for activities that count and display their lifecycle method calls
 */
abstract class CountingActivity : AppCompatActivity() {
    protected var counter: LifecycleMethodCounter = LifecycleMethodCounter()

    /**
     * The TAG that will be used for logging
     */
    abstract val TAG : String

    lateinit var binding : ActivityOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_one)
        binding.counter = counter

        //If savedInstanceState is not null, getSerializable will be called
        //Otherwise this line is skipped
        savedInstanceState?.let {
            binding.counter = it.getSerializable(COUNTER) as LifecycleMethodCounter
        }

        counter.onCreateCalled()
        updateUI()
        Log.i(TAG, "onCreate called ${counter.onCreate} times")
    }


    fun updateUI(){
        binding.counter = counter
    }

    override fun onStart() {
        super.onStart()
        counter.onStartCalled()
        updateUI()
        Log.i(TAG, "onStart called ${counter.onCreate} times")
    }

    override fun onResume() {
        super.onResume()
        counter.onResumeCalled()
        updateUI()
        Log.i(TAG, "onResume called ${counter.onCreate} times")
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestartCalled()
        updateUI()
        Log.i(TAG, "onRestart called ${counter.onCreate} times")
    }

    override fun onPause() {
        super.onPause()
        counter.onPauseCalled()
        updateUI()
        Log.i(TAG, "onPause called ${counter.onCreate} times")
    }

    override fun onStop() {
        super.onStop()
        counter.onStopCalled()
        updateUI()
        Log.i(TAG, "onStop called ${counter.onCreate} times")
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroyCalled()
        updateUI()
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