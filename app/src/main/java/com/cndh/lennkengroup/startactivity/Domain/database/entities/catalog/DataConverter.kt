package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class DataConverter {

    @TypeConverter
    fun getDataList(dataList: String): List<Data>?{

        if (dataList == null){
            return  null
        }
        var gson = Gson()
        val listType = object : TypeToken<List<Data>>() {

        }.type

        return gson.fromJson(dataList,listType)

    }

    @TypeConverter
    fun setDataList(dataList: List<Data>): String?{

        return Gson().toJson(dataList)
    }
}