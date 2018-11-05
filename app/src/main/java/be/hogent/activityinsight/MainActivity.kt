package be.hogent.activityinsight

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import be.hogent.activityinsight.databinding.ActivityOneBinding


class MainActivity : CountingActivity() {

    override fun onStart() {
        super.onStart()
        mCountingViewModel.secondActivityEvent.observe(this, Observer {
            startActivity(SecondActivity.newIntent(this))
        })
    }

    override fun initializeViewAndDataBinding() {
        val binding: ActivityOneBinding = DataBindingUtil.setContentView(this, R.layout.activity_one)

        mCountingViewModel = ViewModelProviders.of(this).get(CountingViewModel::class.java)

        binding.viewModel = mCountingViewModel
        binding.setLifecycleOwner(this)
    }

}
