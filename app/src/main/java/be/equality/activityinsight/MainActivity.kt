package be.equality.activityinsight

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {

    private var counter : LifecycleMethodCounter = LifecycleMethodCounter(0,0,0,0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter.onCreate++
        textViewOnCreateNumber.text = "${counter.onCreate}"
    }

    override fun onStart() {
        super.onStart()
        counter.onStart++;
        textViewOnStartNumber.text = "${counter.onStart}"

    }

    override fun onResume() {
        super.onResume()
        counter.onResume++
        textViewOnResumeNumber.text = "${counter.onResume}"
    }

    override fun onRestart() {
        super.onRestart()
        counter.onRestart++
        textViewOnRestartNumber.text = "${counter.onRestart}"
    }

    override fun onPause() {
        super.onPause()
        counter.onPause++
        textViewOnPausetNumber.text =  "${counter.onPause}"

    }

    override fun onStop(){
        super.onStop()
        counter.onStop++
        textViewOnStoptNumber.text = "${counter.onStop}"
    }

    override fun onDestroy() {
        super.onDestroy()
        counter.onDestroy++
        textViewOnDestroyNumber.text = "${counter.onDestroy}"
    }


}
