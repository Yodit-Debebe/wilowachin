package com.example.wilowachin.viewmodel



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.wilowachin.data.local.db.AppDatabase
import com.example.wilowachin.data.model.Journal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedJournalsViewModel(application: Application) : AndroidViewModel(application) {

    private val journalDao: com.example.wilowachin.data.local.dao.JournalDao
    private val _sharedJournals = MutableStateFlow<List<Journal>>(emptyList())  // Use MutableStateFlow
    val sharedJournals: Flow<List<Journal>> = _sharedJournals.asStateFlow() // Expose as StateFlow (read-only)

    init {
        val database = AppDatabase.getInstance(application)
        journalDao = database.journalDao()
        // Load shared journals (replace with your actual logic)
        viewModelScope.launch(Dispatchers.IO) {
            //  Replace this with your actual logic to fetch shared journals.
            //  For now, I'm just getting all journals as a placeholder.
            val allJournals = journalDao.getAllJournals()
            allJournals.collect { journals ->
                _sharedJournals.value = journals.filter { it.id % 2 == 0 }
            }

        }
    }

    //  Add a function to share a journal (this is a placeholder)
    fun shareJournal(journalId: Int, recipientEmail: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //  Implement the logic to share the journal (e.g., send data to a server)
            println("Sharing journal $journalId with $recipientEmail")
            //  You might update the database here to indicate that the journal is shared
        }
    }
}