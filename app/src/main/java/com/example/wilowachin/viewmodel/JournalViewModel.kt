//package com.example.wilowachin.viewmodel
//
//import android.app.Application
//import android.util.Log
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.wilowachin.data.local.db.AppDatabase
//import com.example.wilowachin.data.model.Journal
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.onEach
//import kotlinx.coroutines.launch
//
//// Use AndroidViewModel to get access to the Application context
//class MyJournalsViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val journalDao: com.example.wilowachin.data.local.dao.JournalDao
//    val allJournals: Flow<List<Journal>>
//
//    init {
//        val database = AppDatabase.getInstance(application)
//        journalDao = database.journalDao()
//        allJournals = journalDao.getAllJournals().onEach {
//            Log.d("MyScreenJournalViewModel", "Emitting journal: $it")
//        }
//
//    }
//
//    fun insertJournal(journal: Journal) {
//        viewModelScope.launch(Dispatchers.IO) {
//            journalDao.insertJournal(journal)
//        }
//    }
//
//    fun deleteJournal(journal: Journal) {
//        viewModelScope.launch(Dispatchers.IO) {
//            journalDao.deleteJournal(journal)
//        }
//    }
//
//    fun deleteJournalById(id: Int) {
//        viewModelScope.launch(Dispatchers.IO) {
//            journalDao.deleteJournalById(id)
//        }
//    }
//}


package com.example.wilowachn.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.wilowachin.data.local.db.AppDatabase
import com.example.wilowachin.data.model.Journal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

// Use AndroidViewModel to get access to the Application context
class MyJournalsViewModel(application: Application) : AndroidViewModel(application) {

    private val journalDao: com.example.wilowachin.data.local.dao.JournalDao
    private val _allJournals = MutableStateFlow<List<Journal>>(emptyList())
    val allJournals: Flow<List<Journal>> = _allJournals.asStateFlow()

    init {
        val database = AppDatabase.getInstance(application)
        journalDao = database.journalDao()
        viewModelScope.launch { // Moved to viewModelScope
            journalDao.getAllJournals()
                .onEach {
                    Log.d("MyJournalsViewModel", "Emitting journals: $it")
                    _allJournals.value = it
                }
                .catch {  // Added catch for error handling
                    Log.e("MyJournalsViewModel", "Error fetching journals", it)
                    // Consider showing an error message to the user
                }
                .collect { journals ->  // Added the collect lambda
                    // This is where you receive the data from the Flow
                    _allJournals.value = journals
                }
        }
    }

    fun insertJournal(journal: Journal) {
        viewModelScope.launch(Dispatchers.IO) {
            journalDao.insertJournal(journal)
        }
    }

    fun deleteJournal(journal: Journal) {
        viewModelScope.launch(Dispatchers.IO) {
            journalDao.deleteJournal(journal)
        }
    }

    fun deleteJournalById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            journalDao.deleteJournalById(id)
        }
    }
}
