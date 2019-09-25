package com.cndh.lennkengroup.startactivity.Network

import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.CategoryList
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ServicesApi {

    @GET("movies/categories")
    fun getCategorysMovies(): Observable<CategoryList>
}