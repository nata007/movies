package com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(data: List<Data>)

    @Query("SELECT * FROM category")
    fun getCategoryDao(): CategoryList
}