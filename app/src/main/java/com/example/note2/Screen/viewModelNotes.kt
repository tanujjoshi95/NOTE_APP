package com.example.note2.Screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note2.Data.NoteDataSource
import com.example.note2.Model.Note
import com.example.note2.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class viewModelNotes @Inject constructor(private val repository : NoteRepository)  : ViewModel() {
        private val _noteList= MutableStateFlow<List<Note>>(emptyList())
    val noteList=_noteList.asStateFlow()

    //    private var noteList= mutableStateListOf<Note>()
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotes().distinctUntilChanged()
                .collectLatest {
                    listOfNotes->
                    if (listOfNotes.isEmpty()){
                        Log.d("Empty",":  Empty List")
                    }
                    else{
                        _noteList.value=listOfNotes
                    }
                }
        }
        //noteList.addAll(NoteDataSource().loadNotes())
    }
    fun addNote(note:Note)= viewModelScope.launch { repository.addNote(note) }
    //fun updateNote(note: Note)=viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note: Note)=viewModelScope.launch { repository.delete(note) }

//    fun addNote(note:Note){
//        noteList.add(note)
//    }
//
//    fun removeNote(note:Note){
//        noteList.remove(note)
//    }
//    fun getNotes():List<Note>{
//        return noteList
//    }
}