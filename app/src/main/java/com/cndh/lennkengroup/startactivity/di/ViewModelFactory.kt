package com.cndh.lennkengroup.startactivity.di

import android.app.Activity
import android.util.DisplayMetrics
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cndh.lennkengroup.startactivity.Domain.database.AppDatabase
import com.cndh.lennkengroup.startactivity.base.BaseViewModel
import com.cndh.lennkengroup.startactivity.scenes.category.CategoryViewModel


class ViewModelFactory(private val activity: Activity):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val db = AppDatabase.getAppDataBase(activity)!!

        var viewmodel: T? = null
        @Suppress("UNCHECKED_CAST")
        when{
            modelClass.isAssignableFrom(CategoryViewModel::class.java) ->
                viewmodel = CategoryViewModel(db.categoryDao()) as T
        }
        viewmodel?.apply {
            (this as? BaseViewModel)?.context = activity
            val dimensions = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(dimensions)
            (this as? BaseViewModel)?.screen = BaseViewModel.ScreenSize(
                dimensions.heightPixels,
                dimensions.widthPixels
            )
            return this
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}