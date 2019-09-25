package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "category")
data class CategoryList(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "ok")
    var ok: Boolean,
    @ColumnInfo(name = "data")
    @TypeConverters(DataConverter::class)
    var data: List<Data>
)