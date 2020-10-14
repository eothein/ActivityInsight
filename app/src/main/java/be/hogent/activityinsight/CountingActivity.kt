package be.hogent.activityinsight

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import be.hogent.activityinsight.databinding.ActivityOneBinding
import timber.log.Timber


/**
 * This class is a superclass for activities that count and display their lifecycle method calls
 */
abstract class CountingActivity : AppCompatActivity() {
    protected var counter: LifecycleMethodCounter = LifecycleMethodCounter()


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
        Timber.i("oncreate called ${counter.onCreate} times")
    }


    private fun updateUI(){
        binding.counter = counter
    }

    override fun onStart() {
        super.onStart()
        counter.onStartCalled()
        updateUI()
        Timber.i("onStart called ${counter.onCreate} times")
    }

    override fun onResume() {
        super.onResume()
        counter.onResumeCalled()
        updateUI()
        Timber.i("onResume called ${counter.onCreate} times")
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestartCalled()
        updateUI()
        Timber.i("onRestart called ${counter.onCreate} times")
    }

    override fun onPause() {
        super.onPause()
        counter.onPauseCalled()
        updateUI()
        Timber.i("onPause called ${counter.onCreate} times")
    }

    override fun onStop() {
        super.onStop()
        counter.onStopCalled()
        updateUI()
       Timber.i("onStop called ${counter.onCreate} times")
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroyCalled()
        updateUI()
        Timber.i("onDestroy called ${counter.onCreate} times")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(COUNTER, counter)
        Timber.i("saving state $counter")
    }



    companion object {
        private const val COUNTER = "counter"
    }
}