package be.equality.activityinsight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var counter: LifecycleMethodCounter = LifecycleMethodCounter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter.onCreateCalled()
        textViewOnCreateNumber.text = "${counter.onCreate}"
    }

    override fun onStart() {
        super.onStart()
        counter.onStartCalled()
        textViewOnStartNumber.text = "${counter.onStart}"

    }

    override fun onResume() {
        super.onResume()
        counter.onResumeCalled()
        textViewOnResumeNumber.text = "${counter.onResume}"
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestartCalled()
        textViewOnRestartNumber.text = "${counter.onRestart}"
    }

    override fun onPause() {
        super.onPause()
        counter.onPauseCalled()
        textViewOnPausetNumber.text = "${counter.onPause}"

    }

    override fun onStop() {
        super.onStop()
        counter.onStopCalled()
        textViewOnStoptNumber.text = "${counter.onStop}"
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroyCalled()
        textViewOnDestroyNumber.text = "${counter.onDestroy}"
    }


}
