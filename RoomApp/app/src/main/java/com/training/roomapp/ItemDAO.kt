package com.training.roomapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDAO {

    @Insert
    suspend fun insertItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("DELETE FROM Item")
    suspend fun deleteAllItems()

    @Query("SELECT * FROM Item ORDER BY id DESC")
    fun  getAllItems() : LiveData<List<Item>>
}