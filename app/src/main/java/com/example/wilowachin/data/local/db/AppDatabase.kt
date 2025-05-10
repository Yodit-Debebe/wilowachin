package com.example.wilowachin.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wilowachin.data.local.dao.JournalDao
import com.example.wilowachin.data.model.Journal

@Database(entities = [Journal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun journalDao(): JournalDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "wilowachin_db" // Database name
                ).build().apply {
                    INSTANCE = this
                }
                instance
            }
        }
    }
}