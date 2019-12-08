package org.softhk.mvp.data.repository.ds

import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note

interface NoteDataSource {

    fun addNote(note: Note): Unit

    fun findNoteById(id: Int): LiveData<Note>

    fun updateNote(note: Note): Unit

    fun deleteNote(note: Note): Unit

    fun getAllNote():LiveData<List<Note>>
}