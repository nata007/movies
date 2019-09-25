package com.cndh.lennkengroup.startactivity.scenes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cndh.lennkengroup.startactivity.Domain.database.AppDatabase
import com.cndh.lennkengroup.startactivity.R
import com.cndh.lennkengroup.startactivity.scenes.category.CategoryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Test"
        Handler().postDelayed({
            startActivity(Intent(this,CategoryActivity::class.java))
            finish()
        }, 3000)
    }
}
