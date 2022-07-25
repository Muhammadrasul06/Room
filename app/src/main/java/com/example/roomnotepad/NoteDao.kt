package com.example.roomnotepad

import androidx.room.*
import com.example.roomnotepad.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): ArrayList<Note>

}