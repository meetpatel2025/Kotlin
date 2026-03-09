package com.training.roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun itemDAO(): ItemDAO

    companion object {
        @Volatile
        private var Instance: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "item_database"
                ).build()
                    .also { Instance = it }
            }
        }
    }
}