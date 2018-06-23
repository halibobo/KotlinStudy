package me.dahei.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

abstract class BaseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        ButterKnife.bind(this)
        initPage(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    open fun initPage(savedInstanceState: Bundle?){}


}