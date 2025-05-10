////package com.example.wilowachin.viewmodel
////
////
////import android.app.Application
////import androidx.lifecycle.AndroidViewModel
////import androidx.lifecycle.viewModelScope
////import com.example.wilowachin.data.local.db.AppDatabase
////import kotlinx.coroutines.Dispatchers
////import kotlinx.coroutines.flow.MutableStateFlow
////import kotlinx.coroutines.flow.asStateFlow
////import kotlinx.coroutines.launch
////
////class JournalEditorViewModel(application: Application, journalId: Int) : AndroidViewModel(application) {
////
////    private val journalDao = AppDatabase.getInstance(application).journalDao()
////
////    private val _title = MutableStateFlow("")
////    val title = _title.asStateFlow()
////
////    private val _content = MutableStateFlow("")
////    val content = _content.asStateFlow()
////
////    private var currentJournalId: Int = journalId
////
////    init {
////        if (journalId != 0) {
////            viewModelScope.launch(Dispatchers.IO) {
////                val journal = journalDao.getJournalById(journalId).firstOrNull() // Use firstOrNull()
////                if (journal != null) {
////                    _title.value = journal.title
////                    _content.value = journal.content
////                }
////            }
////        }
////    }
////
////    fun updateTitle(newTitle: String) {
////        _title.value = newTitle
////    }
////
////    fun updateContent(newContent: String) {
////        _content.value = newContent
////    }
////
////    fun saveJournal() {
////        viewModelScope.launch(Dispatchers.IO) {
////            if (currentJournalId == 0) {
////                // Insert new journal
////                val newJournal = com.example.wilowachin.data.model.Journal(title = _title.value, content = _content.value)
////                journalDao.insertJournal(newJournal)
////            } else {
////                // Update existing journal
////                val updatedJournal = com.example.wilowachin.data.model.Journal(id = currentJournalId, title = _title.value, content = _content.value)
////                journalDao.updateJournal(updatedJournal)
////            }
////        }
////    }
////
////    fun deleteJournal() {
////        viewModelScope.launch(Dispatchers.IO) {
////            if (currentJournalId != 0) {
////                journalDao.deleteJournalById(currentJournalId)
////            }
////        }
////    }
////}
//
//
package com.example.wilowachin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.wilowachin.data.local.db.AppDatabase
import com.example.wilowachin.data.model.Journal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.firstOrNull

class JournalEditorViewModel(application: Application, journalId: Int) : AndroidViewModel(application) {

    private val journalDao = AppDatabase.getInstance(application).journalDao()

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    private val _content = MutableStateFlow("")
    val content = _content.asStateFlow()

    private var currentJournalId: Int = journalId

    init {
        if (journalId != 0) {
            viewModelScope.launch(Dispatchers.IO) {
                val journal: Journal? = journalDao.getJournalById(journalId).firstOrNull()
                if (journal != null) {
                    _title.value = journal.title
                    _content.value = journal.content
                }
            }
        }
    }

    fun updateTitle(newTitle: String) {
        _title.value = newTitle
    }

    fun updateContent(newContent: String) {
        _content.value = newContent
    }

    fun saveJournal() {
        viewModelScope.launch(Dispatchers.IO) {
            if (currentJournalId == 0) {
                // Insert new journal
                val newJournal = Journal(title = _title.value, content = _content.value)
                journalDao.insertJournal(newJournal)
            } else {
                // Update existing journal
                val updatedJournal = Journal(id = currentJournalId, title = _title.value, content = _content.value)
                journalDao.updateJournal(updatedJournal)
            }
        }
    }

    fun deleteJournal() {
        viewModelScope.launch(Dispatchers.IO) {
            if (currentJournalId != 0) {
                journalDao.deleteJournalById(currentJournalId)
            }
        }
    }
}



