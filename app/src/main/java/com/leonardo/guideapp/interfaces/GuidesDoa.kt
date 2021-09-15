package com.leonardo.guideapp.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leonardo.guideapp.data.Guide

@Dao
interface GuidesDoa {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Guide>)

    @Query("SELECT * FROM guides")
    fun getAll() : LiveData<List<Guide>>


}