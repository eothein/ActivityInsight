package be.hogent.activityinsight

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import be.hogent.activityinsight.databinding.ActivityTwoBinding

class SecondActivity : CountingActivity() {

    override fun onStart() {
        super.onStart()
        mCountingViewModel.backEvent.observe(this, Observer {
            finish()
        })
    }

    override fun initializeViewAndDataBinding() {
        val binding: ActivityTwoBinding = DataBindingUtil.setContentView(this, R.layout.activity_two)

        mCountingViewModel = ViewModelProviders.of(this).get(CountingViewModel::class.java)

        binding.viewModel = mCountingViewModel
        binding.setLifecycleOwner(this)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }
}


