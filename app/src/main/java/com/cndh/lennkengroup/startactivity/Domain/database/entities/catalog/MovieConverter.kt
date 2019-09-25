package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieConverter {

    @TypeConverter
    fun getMovieList(dataList: String): List<Movie>?{

        if (dataList == null){
            return  null
        }
        var gson = Gson()
        val listType = object : TypeToken<List<Movie>>() {

        }.type

        return gson.fromJson(dataList,listType)

    }

    @TypeConverter
    fun setMovieList(dataList: List<Movie>): String?{

        return Gson().toJson(dataList)
    }
}