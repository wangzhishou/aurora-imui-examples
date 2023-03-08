package cn.jiguang.imuisample.themes

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import cn.jiguang.imuisample.R
import cn.jiguang.imuisample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onClick(view: View?) {
        val intent = Intent(this, ThemeActivity::class.java)
        when (view?.id) {
            R.id.default_theme_btn -> {
                intent.putExtra("style", ThemeStyle.DEFAULT.name)
            }
            R.id.light_theme_btn -> {
                intent.putExtra("style", ThemeStyle.LIGHT.name)
            }
            R.id.black_theme_btn -> {
                intent.putExtra("style", ThemeStyle.BLACK.name)
            }
        }
        startActivity(intent)
    }



}
