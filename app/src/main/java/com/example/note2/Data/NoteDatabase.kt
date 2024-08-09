package com.example.note2.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.note2.Model.Note
import com.example.note2.util.DateConverter
import com.example.note2.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase:RoomDatabase() {
   abstract fun noteDao():NoteDatabaseDao
}

