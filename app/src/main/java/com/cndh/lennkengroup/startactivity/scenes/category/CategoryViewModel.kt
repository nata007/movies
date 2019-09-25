package com.cndh.lennkengroup.startactivity.scenes.category

import android.widget.Toast
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.CategoryDao
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.CategoryList
import com.cndh.lennkengroup.startactivity.Network.ServicesApi
import com.cndh.lennkengroup.startactivity.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class CategoryViewModel(private val dao: CategoryDao): BaseViewModel() {
    @Inject
    lateinit var servicesApi: ServicesApi

    lateinit var subscription: Disposable


    fun buildServices(complete:(list:CategoryList?) -> Unit){
        subscription = servicesApi
            .getCategorysMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveStart() }
            .doOnTerminate { onRetrieveFinish() }
            .doOnError { onRetrieveError(it) }
            .subscribe({
                saveCategory(it)
                complete(it)
            }, {
                onRetrieveFinish()
                onRetrieveError(it)
                complete(null)
            })
    }

    fun saveCategory(it: CategoryList){
        try {
            dao.insertCategory(it.data)
        }catch (e: Exception){
            Toast.makeText(context,"Error Dao {${e.toString()}}",Toast.LENGTH_LONG).show()
        }
    }


}