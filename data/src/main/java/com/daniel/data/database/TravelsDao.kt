package com.daniel.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daniel.domain.entity.Travel

@Dao
interface TravelsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTravels(travels: List<Travel>?)

    @Query("SELECT * FROM travels")
    fun getAllTravels(): LiveData<List<Travel>>
}