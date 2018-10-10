package be.hogent.activityinsight

import kotlinx.android.synthetic.main.activity_two.*

class SecondActivity : CountingActivity() {

    override val TAG: String = "MainActivity"

    override fun getLayoutId() = R.layout.activity_two

    override fun onStart() {
        super.onStart()
        btn_prev_activity.setOnClickListener {
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        btn_prev_activity.setOnClickListener(null)
    }
}


