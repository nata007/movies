package com.cndh.lennkengroup.startactivity.base

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cndh.lennkengroup.startactivity.di.DaggerViewModelInjection
import com.cndh.lennkengroup.startactivity.di.NetworkInjection
import com.cndh.lennkengroup.startactivity.di.ViewModelInjection

import com.cndh.lennkengroup.startactivity.scenes.category.CategoryViewModel
import com.cndh.lennkengroup.startactivity.scenes.shared.LoadingActivity

abstract class BaseViewModel: ViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    private var loadingActivity: LoadingActivity? = null
    var context: Activity = Activity()
        set(value) {
            field = value
            contextInitalized()
        }
    internal lateinit var screen: ScreenSize
    data class ScreenSize(val h: Int = 0, val w: Int = 0)

    lateinit var mContext : Context

    fun setContext(context: Context){
        mContext = context
    }

    private val injector: ViewModelInjection = DaggerViewModelInjection
        .builder().networkModule(NetworkInjection)
        .build()

    init {
        inject()
    }

    open fun contextInitalized() {
    }

    fun onRetrieveStart() {
        if (loadingActivity == null && context != null) {
            if (::mContext.isInitialized){
                loadingActivity = LoadingActivity(activity = mContext)
            }else{
                loadingActivity = LoadingActivity(activity = context)
            }
        }
    }

    fun onRetrieveFinish(){
        try {
            loadingActivity?.let {
                it.loading.dismiss()
                loadingActivity = null
            }
        }catch (e:Exception){}
    }

    fun onRetrieveError(error: Throwable){
//        Toast.makeText(context,"Error Services",Toast.LENGTH_LONG).show()
        Log.e("Error", error.localizedMessage)
    }


    private fun inject() {
        when (this) {

            is CategoryViewModel -> injector.inject(this)

        }
    }
}