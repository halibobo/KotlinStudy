package me.dahei.myapplication.basic

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import butterknife.OnClick
import me.dahei.myapplication.BaseActivity
import me.dahei.myapplication.GrammarAdapter
import me.dahei.myapplication.R
import me.dahei.myapplication.constant.Constants
import me.dahei.myapplication.data.KotlinItem
import me.dahei.myapplication.display.DisplayDialogFragment
import android.support.v7.widget.RecyclerView

class GrammarActivity : BaseActivity() {

    private val bundle:Bundle = Bundle()
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.listView)
    }

    private val mContainer = arrayListOf<KotlinItem>(
            KotlinItem("\n" +
                    "    /**\n" +
                    "     * 带有两个 Int 参数、返回 Int 的函数：\n" +
                    "     */\n" +
                    "    private fun sum(a: Int, b: Int): Int {\n" +
                    "        return a + b\n" +
                    "    }",
                    "sum(2, 3)",
                    sum(2, 3).toString()),
            KotlinItem("\n" +
                    "    /**\n" +
                    "     * 将表达式作为函数体、返回值类型自动推断的函数\n" +
                    "     */\n" +
                    "    private fun sum(a: Int, b: Int, c: Int) = a + b + c\n",
                    "sum(2, 3, 4)",
                    sum(2, 3, 4).toString())
    )

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
        val viewAdapter = GrammarAdapter(this, mContainer)
        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun exeFun(title:String,content:String,outCome:String) {
        val dialogFragment = DisplayDialogFragment()
        bundle.putString(Constants.FUN_TITLE, title)
        bundle.putString(Constants.FUN_CONTENT, content)
        bundle.putString(Constants.FUN_OUTCOME, outCome)

        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "alertDialog")
    }

    /**
     * 带有两个 Int 参数、返回 Int 的函数：
     */
    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 将表达式作为函数体、返回值类型自动推断的函数
     */
    private fun sum(a: Int, b: Int, c: Int) = a + b + c


    /**
     * 无意义的返回值
     */
    private fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    /**
     * 返回值Unit可以省略
     */
    private fun printSum(a: String, b: String) {
        println("sum of $a and $b is ${a + b}")
    }
}

