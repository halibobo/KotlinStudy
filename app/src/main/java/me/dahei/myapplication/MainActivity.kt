package me.dahei.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import me.dahei.myapplication.basic.BasicGrammar
import me.dahei.myapplication.basic.GrammarActivity
import me.dahei.myapplication.constant.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.grammar)
    fun gotToGrammarActivity() {
        val kotlinNote = BasicGrammar().note()
        var intent = Intent(this,GrammarActivity::class.java)
        intent.putExtra(Constants.INTENT_GRAMMAER, kotlinNote)
        startActivity(intent)
    }
}
