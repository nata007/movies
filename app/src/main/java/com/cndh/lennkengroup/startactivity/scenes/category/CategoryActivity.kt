package com.cndh.lennkengroup.startactivity.scenes.category

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Data
import com.cndh.lennkengroup.startactivity.R
import com.cndh.lennkengroup.startactivity.di.ViewModelFactory
import com.cndh.lennkengroup.startactivity.scenes.category.movies.MoviesActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_category.*

interface OnSelectCategory {
    fun onListDataInteraction(item: Data)
}
class CategoryActivity : AppCompatActivity(), OnSelectCategory {

    override fun onListDataInteraction(item: Data) {
        startActivity(Intent(this, MoviesActivity::class.java).putExtra("data",Gson().toJson(item)))
    }

    private lateinit var categoryViewModel: CategoryViewModel


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        title = "Home"
        categoryViewModel = ViewModelProviders.of(
            this,ViewModelFactory(this)).get(CategoryViewModel::class.java)

        categoryViewModel.buildServices{
            result ->
            if (result != null)
            with(this.categoryRecycler){
                this.setHasFixedSize(true)
                this.adapter = CategoryAdapter(result!!,this@CategoryActivity)
                this.layoutManager =
                    LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            }
           else
                Toast.makeText(this.baseContext,"Not Found",Toast.LENGTH_LONG).show()
        }

    }
}
