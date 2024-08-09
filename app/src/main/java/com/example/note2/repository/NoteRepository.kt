package com.example.note2.repository

import com.example.note2.Data.NoteDatabaseDao
import com.example.note2.Model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao:NoteDatabaseDao) {
    suspend fun addNote(note:Note)=noteDatabaseDao.insert(note)
    suspend fun updateNote(note:Note)=noteDatabaseDao.update(note)
    suspend fun delete(note:Note)=noteDatabaseDao.deleteNote(note)
   // suspend fun deleteAllNote()=noteDatabaseDao.deleteAll()
    fun getAllNotes():Flow<List<Note>> =noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()

}