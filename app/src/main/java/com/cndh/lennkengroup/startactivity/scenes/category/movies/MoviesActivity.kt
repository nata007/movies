package com.cndh.lennkengroup.startactivity.scenes.category.movies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Data
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Movie
import com.cndh.lennkengroup.startactivity.R
import com.cndh.lennkengroup.startactivity.scenes.category.CategoryAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_movies.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MoviesActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        title = "Movies"
        var json = intent.getStringExtra("data")
        var data:Data = Gson().fromJson(json,object : TypeToken<Data>() {}.type)
        doAsync{

            uiThread {
                moviesRecycler.setHasFixedSize(true)
                moviesRecycler.layoutManager = LinearLayoutManager(this@MoviesActivity,LinearLayoutManager.VERTICAL,false)
                moviesRecycler.adapter = MoviesAdapter(data.movies,data.color)

            }


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
