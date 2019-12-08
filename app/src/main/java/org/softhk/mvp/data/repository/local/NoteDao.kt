package org.softhk.mvp.data.repository.local

import androidx.lifecycle.LiveData
import androidx.room.*
import org.softhk.mvp.data.entity.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM Note WHERE id = :id")
    fun findNoteById(id: Int): LiveData<Note>

    @Query("SELECT * FROM Note")
    fun getAllNotes(): LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)


}