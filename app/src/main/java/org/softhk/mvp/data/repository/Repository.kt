package org.softhk.mvp.data.repository

import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note

interface Repository {

    fun addNote(note: Note)

    fun findNoteById(id: Int): LiveData<Note>

    fun updateNote(note: Note)

    fun deleteNote(note: Note)

    fun getAllNote(): LiveData<List<Note>>
}