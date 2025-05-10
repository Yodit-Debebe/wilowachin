package com.example.wilowachin.data.local.dao

import androidx.room.*
import com.example.wilowachin.data.model.Journal
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journals ORDER BY createdAt DESC")
    fun getAllJournals(): Flow<List<Journal>>

    @Query("SELECT * FROM journals WHERE id = :id")
    fun getJournalById(id: Int): Flow<Journal?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJournal(journal: Journal)

    @Update
    suspend fun updateJournal(journal: Journal)

    @Delete
    suspend fun deleteJournal(journal: Journal)

    @Query("DELETE FROM journals WHERE id = :id")
    suspend fun deleteJournalById(id: Int)
}