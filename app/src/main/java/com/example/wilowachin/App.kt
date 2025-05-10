import android.app.Application
import com.example.wilowachin.data.local.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.firstOrNull


//package com.example.wilowachin
//
//
//import android.app.Application
//
//class App : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        // Initialize any global resources here if needed
//    }
//}




class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // ...
        //  TEMPORARY: Insert a journal for testing
        val database = AppDatabase.getInstance(this)
        val journalDao = database.journalDao()
        CoroutineScope(Dispatchers.IO).launch {
            if (journalDao.getAllJournals().firstOrNull()?.isEmpty() != false) { //check if the database is empty
                journalDao.insertJournal(
                    com.example.wilowachin.data.model.Journal(
                        title = "Test Journal",
                        content = "This is a test journal entry."
                    )
                )
            }

        }
    }
}
