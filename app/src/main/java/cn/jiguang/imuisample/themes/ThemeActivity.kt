package cn.jiguang.imuisample.themes

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import cn.jiguang.imuisample.R
import cn.jiguang.imuisample.ViewModelFactory
import cn.jiguang.imuisample.databinding.ActivityThemeBinding
import cn.jiguang.imuisample.model.MessageViewModel
import cn.jiguang.imuisample.util.ActivityUtils


class ThemeActivity : AppCompatActivity() {

    lateinit private var mBinding: ActivityThemeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_theme)
        val fragment = obtainViewFragment()
        ActivityUtils.replaceFragmentInActivity(supportFragmentManager,
                fragment, mBinding.contentFrame.id)

    }

    companion object {
        fun obtainViewModel(activity: FragmentActivity): MessageViewModel {
            val viewModelFactory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, viewModelFactory).get(MessageViewModel::class.java)
        }
    }

    private fun obtainViewFragment(): Fragment {
        var style = ThemeStyle.DEFAULT
        val styleStr = intent.getStringExtra("style")
        if (styleStr == ThemeStyle.BLACK.name) {
            style = ThemeStyle.BLACK
        } else if (styleStr == ThemeStyle.LIGHT.name) {
            style = ThemeStyle.LIGHT
        }
        return ThemeFragment.newInstance(style)
    }
}