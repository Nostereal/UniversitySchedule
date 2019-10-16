package com.nostereal.universityschedule.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nostereal.universityschedule.data.local.pairs.PairEntity

@Database(entities = [(PairEntity::class)], version = 1)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract fun roomPairDao(): PairDao

    companion object {
        private const val DATABASE = "pairs"

        // Singleton implementation
        @Volatile
        private var instance: ScheduleDatabase? = null

        fun getInstance(context: Context): ScheduleDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ScheduleDatabase {
            return Room.databaseBuilder(context, ScheduleDatabase::class.java, DATABASE).build()
        }
    }
}