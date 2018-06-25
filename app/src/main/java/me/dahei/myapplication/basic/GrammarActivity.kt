package me.dahei.myapplication.basic

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import butterknife.OnClick
import me.dahei.myapplication.BaseActivity
import me.dahei.myapplication.GrammarAdapter
import me.dahei.myapplication.R
import android.support.v7.widget.RecyclerView
import me.dahei.myapplication.constant.Constants
import me.dahei.myapplication.data.KotlinNote

class GrammarActivity : BaseActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.listView)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_grammar
    }

    override fun initPage(savedInstanceState: Bundle?) {
        super.initPage(savedInstanceState)
        init()
    }

    @OnClick(R.id.grammar)
    fun gotToActivity() {
    }

    private fun init() {
        viewManager = LinearLayoutManager(this)
        if(intent.hasExtra(Constants.INTENT_GRAMMAER)) {
            val data: KotlinNote = intent.getSerializableExtra(Constants.INTENT_GRAMMAER) as KotlinNote
            val viewAdapter = GrammarAdapter(this, data.notes)
            recyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }
}

