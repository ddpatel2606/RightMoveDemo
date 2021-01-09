package com.dixitpatel.rightmovedemo.ui.main

import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.dixitpatel.rightmovedemo.R
import com.dixitpatel.rightmovedemo.databinding.ActivityMainBinding
import com.dixitpatel.rightmovedemo.ui.adapter.PropertyAdapter
import com.dixitpatel.rightmovedemo.ui.base.BaseActivity
import com.dixitpatel.rightmovedemo.utils.Alerts
import java.text.DecimalFormat
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel?>()
{
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    @Inject
    lateinit var model: MainActivityViewModel

    override fun getViewModel(): MainActivityViewModel {
        return model
    }

    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.progressBar.run {
            roundBorder = true
            indeterminateMode = true
            progressBarColor = ContextCompat.getColor(this@MainActivity, R.color.color_primary)
            progressBarWidth = 4F
            backgroundProgressBarWidth = 4F
            backgroundProgressBarColor = ContextCompat.getColor(this@MainActivity, R.color.transparent)
        }
        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = PropertyAdapter()
            vm = model
        }

        model.pokemonListLiveData.observe(this, Observer {
            model.calculateAverage.value =
                "Average : ${DecimalFormat("####0.00").format(it . map { it -> it!!.price }.average())}"
        })

    }

    override fun onBackPressed() {
        if (backPressedTime + 2500 > System.currentTimeMillis()) {
            super.onBackPressed()
            ActivityCompat.finishAffinity(this)
        } else {
            Alerts.showSnackBar(
                this@MainActivity, resources.getString(R.string.double_press_exit)
            )
        }
        backPressedTime = System.currentTimeMillis()
    }
}