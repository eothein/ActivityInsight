package be.hogent.activityinsight

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_one.*

class MainActivity : CountingActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBar("First Activity")
    }

    override fun onStart() {
        super.onStart()
        btn_next_activity.setOnClickListener {
            startActivity(SecondActivity.newIntent(this))
        }
    }

    override fun onStop() {
        super.onStop()
        btn_next_activity.setOnClickListener(null)
    }
}
