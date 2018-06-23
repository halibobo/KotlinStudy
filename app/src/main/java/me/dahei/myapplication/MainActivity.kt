package me.dahei.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import me.dahei.myapplication.basic.GrammarActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.grammar)
    fun gotToGrammarActivity() {
        startActivity(Intent(this,GrammarActivity::class.java))
    }
}
