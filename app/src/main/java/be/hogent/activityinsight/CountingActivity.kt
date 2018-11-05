package be.hogent.activityinsight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * This class is a superclass for activities that count and display their lifecycle method calls
 */
abstract class CountingActivity : AppCompatActivity() {

    lateinit var mCountingViewModel: CountingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewAndDataBinding()

        mCountingViewModel.onCreateCalled()

    }

    /**
     * This method sets the view, creates and sets the viewmodel, and sets up the databinding.
     * Setting up the databinding consists of getting the binding class, setting its viewmodel
     * and registering the lifecycleowner.
     *
     * This can't be done here because each activity has its own layout file and thus its own binding class.
     */
    abstract fun initializeViewAndDataBinding()

    override fun onStart() {
        super.onStart()
        mCountingViewModel.onStartCalled()
    }

    override fun onResume() {
        super.onResume()
        mCountingViewModel.onResumeCalled()
    }

    override fun onRestart() {
        super.onRestart()
        mCountingViewModel.onRestartCalled()
    }

    override fun onPause() {
        super.onPause()
        mCountingViewModel.onPauseCalled()
    }

    override fun onStop() {
        super.onStop()
        mCountingViewModel.onStopCalled()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountingViewModel.onDestroyCalled()
    }

}