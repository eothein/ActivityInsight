package be.hogent.activityinsight

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import be.hogent.activityinsight.databinding.ActivityOneBinding
import kotlinx.android.synthetic.main.activity_one.*


class MainActivity : CountingActivity() {


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
