package com.daniel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daniel.domain.entity.Travel

@Database(version = 1, entities = [Travel::class])

abstract class TravelsDatabase : RoomDatabase() {
    abstract fun travelDao(): TravelsDao
}