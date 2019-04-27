package com.example.reezkyillma.kotlintigabelas.ui.listeners

import android.text.Editable
import android.text.TextWatcher

abstract class MyTextWatcher : TextWatcher {
    override fun onTextChanged(p0: CharSequence?,
                               p1: Int,
                               p2: Int,
                               p3: Int
                               ) {

    }

    override fun beforeTextChanged(p0: CharSequence?,
                                   p1: Int,
                                   p2: Int,
                                   p3: Int
    ) {


    }

    override fun afterTextChanged(p0: Editable?) {
        onTextChanged(p0.toString())
    }

    abstract fun onTextChanged(p0 : String)
}