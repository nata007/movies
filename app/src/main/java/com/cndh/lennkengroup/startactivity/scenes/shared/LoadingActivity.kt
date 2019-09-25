package com.cndh.lennkengroup.startactivity.scenes.shared

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.cndh.lennkengroup.startactivity.R

class LoadingActivity(activity: Context) : Dialog(activity) {

    var loading: Dialog = Dialog(activity, R.style.Theme_Transparent)

    init {
        loading.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loading.setCancelable(false)
        loading.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loading.setContentView(R.layout.activity_loading)
        loading.show()
    }

    fun endLoading() {
        loading.dismiss()
    }
}
