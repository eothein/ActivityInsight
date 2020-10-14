package be.hogent.activityinsight

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_one.*
import kotlinx.android.synthetic.main.activity_two.*

class SecondActivity : CountingActivity() {

    override fun onStart() {
        super.onStart()
        btn_next_activity.setOnClickListener {
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        btn_next_activity.setOnClickListener(null)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }
}
