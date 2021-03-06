package me.dahei.myapplication.display

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import me.dahei.myapplication.R
import me.dahei.myapplication.constant.Constants

class DisplayDialogFragment : DialogFragment() {

    val TAG = "DisplayDialogFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(android.app.DialogFragment.STYLE_NO_FRAME, R.style.default_dialog_style)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = inflater.inflate(R.layout.fragment_display, container)

        val bundle = arguments
        val title = bundle?.getString(Constants.FUN_TITLE)
        view.findViewById<TextView>(R.id.textTitle).text = title

        val content = bundle?.getString(Constants.FUN_CONTENT)
        view.findViewById<TextView>(R.id.textContent).text = content

        val btnOutcome = view.findViewById<TextView>(R.id.textOutcome)
        btnOutcome.visibility = View.INVISIBLE
        val btnExe = view.findViewById<Button>(R.id.btnExe)
        btnExe.setOnClickListener{
            Log.d(TAG,"exe")
            btnOutcome.visibility = View.VISIBLE
        }

        val outcome = bundle?.getString(Constants.FUN_OUTCOME)
        btnOutcome.text = outcome



        return view
    }
}