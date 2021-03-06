package me.dahei.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.dahei.myapplication.constant.Constants
import me.dahei.myapplication.data.NoteItem
import me.dahei.myapplication.display.DisplayDialogFragment

class GrammarAdapter(private val context : Context,private val myDataSet: ArrayList<NoteItem>) :RecyclerView.Adapter<GrammarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.grammar_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.textView.findViewById<TextView>(R.id.textTitle)
        textView.text = myDataSet[position].title
        holder.textView.setOnClickListener {
            exeFun(
                    myDataSet[position].title,
                    myDataSet[position].content,
                    myDataSet[position].outcome
        ) }
    }

    override fun getItemCount() = myDataSet.size

    private val bundle = Bundle()
    private fun exeFun(title: String, content: String, outCome: String) {
        Log.d("exeFun", "exeFun")
        val dialogFragment = DisplayDialogFragment()
        bundle.putString(Constants.FUN_TITLE, title)
        bundle.putString(Constants.FUN_CONTENT, content)
        bundle.putString(Constants.FUN_OUTCOME, outCome)

        dialogFragment.arguments = bundle
        dialogFragment.show((context as AppCompatActivity).supportFragmentManager, "alertDialog")
    }

    class ViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)
}