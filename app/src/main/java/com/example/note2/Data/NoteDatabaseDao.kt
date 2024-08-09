package com.example.note2.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.note2.Model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("Select * from notes_tbl")
    fun getNotes():Flow<List<Note>>

    @Query("Select * from notes_tbl where id=:id ")
   suspend fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
   suspend fun update(note:Note)

    @Query("Delete from notes_tbl")
   suspend fun deleteAll()

   @Delete
   suspend fun deleteNote(note:Note)

}