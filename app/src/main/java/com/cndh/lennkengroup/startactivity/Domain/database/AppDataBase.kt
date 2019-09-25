package com.cndh.lennkengroup.startactivity.Domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.*


@Database(
    entities = arrayOf(CategoryList::class,
        Movie::class,
        Data::class), version = 1
)
@TypeConverters(DataConverter::class,MovieConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    companion object {
        var INSTANCE: AppDatabase? = null
        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){

                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Test.db")
                            .allowMainThreadQueries()
                            .build()

            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}