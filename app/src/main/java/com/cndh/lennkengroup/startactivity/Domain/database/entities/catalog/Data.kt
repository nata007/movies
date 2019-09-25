package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "data")
data class Data(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "color")
    var color: String,
    @ColumnInfo(name = "status")
    var status: Int,
    @ColumnInfo(name = "movies")
    @TypeConverters(MovieConverter::class)
    var movies: List<Movie>
)