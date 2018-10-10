package be.hogent.activityinsight

import kotlinx.android.synthetic.main.activity_one.*


class MainActivity : CountingActivity() {
    override val TAG: String = "MainActivity"

    override fun getLayoutId() = R.layout.activity_one

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
