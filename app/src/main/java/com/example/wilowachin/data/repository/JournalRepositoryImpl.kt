//package com.example.wilowachin.data.repository
//
//
//import com.example.wilowachin.data.model.Journal
//import com.example.wilowachin.data.local.db.AppDatabase
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
//class JournalRepository {
//    private val dao = AppDatabase.instance.dao
//
//    private val _myJournals = MutableStateFlow(dao.getAll().toMutableList())
//    val myJournals = _myJournals.asStateFlow()
//
//    private val _sharedWithMe = MutableStateFlow(dao.getAllShared().toMutableList())
//    val sharedWithMe = _sharedWithMe.asStateFlow()
//
//    fun getJournalById(id: Int?): Journal? = dao.getById(id ?: -1)
//
//    suspend fun addJournal(journal: Journal) {
//        dao.insert(journal)
//        _myJournals.v alue = dao.getAll().toMutableList()
//    }
//
//    suspend fun updateJournal(journal: Journal) {
//        dao.update(journal)
//        _myJournals.value = dao.getAll().toMutableList()
//    }
//
//    suspend fun deleteJournal(id: Int) {
//        dao.delete(id)
//        _myJournals.value = dao.getAll().toMutableList()
//    }
//
//    suspend fun shareJournal(journalId: Int, email: String) {
//        // This is mock logic — in a real app, associate journal with email.
//        val journal = dao.getById(journalId)?.copy(title = "[Shared] " + dao.getById(journalId)?.title)
//        journal?.let {
//            dao.insertShared(it)
//            _sharedWithMe.value = dao.getAllShared().toMutableList()
//        }
//    }
//}
