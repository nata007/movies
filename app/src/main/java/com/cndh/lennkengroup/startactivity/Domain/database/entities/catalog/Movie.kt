package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "subtitle")
    var subtitle: String,
    @ColumnInfo(name = "year")
    var year: Int,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "status")
    var status: Int,
    @ColumnInfo(name = "idCategory")
    var idCategory: Int
)