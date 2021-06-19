package com.example.slash

import android.R.layout
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.IdRes


open class KeyboardView : FrameLayout, View.OnClickListener {
    private var mPasswordField: EditText? = null

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.keyboard, this)
        initViews()
    }

    private fun initViews() {
        mPasswordField = `$`(R.id.auth_phone_number)
        `$`<View>(R.id.t9_key_0).setOnClickListener(this)
        `$`<View>(R.id.t9_key_1).setOnClickListener(this)
        `$`<View>(R.id.t9_key_2).setOnClickListener(this)
        `$`<View>(R.id.t9_key_3).setOnClickListener(this)
        `$`<View>(R.id.t9_key_4).setOnClickListener(this)
        `$`<View>(R.id.t9_key_5).setOnClickListener(this)
        `$`<View>(R.id.t9_key_6).setOnClickListener(this)
        `$`<View>(R.id.t9_key_7).setOnClickListener(this)
        `$`<View>(R.id.t9_key_8).setOnClickListener(this)
        `$`<View>(R.id.t9_key_9).setOnClickListener(this)
        `$`<View>(R.id.t9_key_clear).setOnClickListener(this)
        `$`<View>(R.id.t9_key_backspace).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // handle number button click

        if (v.getTag() != null && "number_button" == v.getTag()) {
           try {
               mPasswordField?.getText()?.append((v as TextView).text)
               return
           } catch (e: Exception){
               println("error")
               println(e)
           }
        }
//         if (v.getTag() != null && "number_button" == v.getTag()) {
//           try {
//               mPasswordField?.getText()?.append((v as TextView).text)
//               return
//           } catch (e: Exception){
//               println("error")
//               println(e)
//           }
//        }
    //        when (v.getId()) {
//            R.id.t9_key_clear -> {
//                // handle clear button
//                mPasswordField?.text = null;
//            }
//            R.id.t9_key_backspace -> {
//                // handle backspace button
//                // delete one character
//                val editable = mPasswordField!!.text
//                val charCount = editable.length
//                if (charCount > 0) {
//                    editable.delete(charCount - 1, charCount)
//                }
//            }
//        }
    }

    val inputText: String
        get() = mPasswordField!!.text.toString()

    protected fun <T : View?> `$`(@IdRes id: Int): T {
        return super.findViewById<View>(id) as T
    }
}