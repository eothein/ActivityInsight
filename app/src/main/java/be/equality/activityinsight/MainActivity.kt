package be.equality.activityinsight

import android.content.Intent
import kotlinx.android.synthetic.main.activity_one.*


class MainActivity : CountingActivity() {
    override val TAG: String = "MainActivity"

    override fun getLayoutId() = R.layout.activity_one

    override fun onStart() {
        super.onStart()
        btn_next_activity.setOnClickListener {
            val otherActivityIntent = Intent(this, SecondActivity::class.java)
            startActivity(otherActivityIntent)
        }
    }

    override fun onStop() {
        super.onStop()
        btn_next_activity.setOnClickListener(null)
    }

}
