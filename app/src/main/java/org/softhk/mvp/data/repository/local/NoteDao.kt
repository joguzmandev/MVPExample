package org.softhk.mvp.data.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.softhk.mvp.data.entity.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM Note WHERE id = :id")
    fun findNoteById(id: Int): Note

    @Query("SELECT * FROM Note")
    fun getAllNotes(): List<Note>

    @Delete
    fun updateNote(note: Note)


}