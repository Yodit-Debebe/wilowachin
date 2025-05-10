package com.example.wilowachin.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journals")
data class JournalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val date: Long,
    val ownerEmail: String,
    val sharedWith: String,
    val permission: String
)


