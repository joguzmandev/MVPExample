package org.softhk.mvp.data.repository.ds

import org.softhk.mvp.data.entity.Note

interface NoteDataSource {

    fun addNote(note: Note): Unit

    fun findNoteById(id: Int): Note

    fun updateNote(note: Note): Unit

    fun deleteNote(note: Note): Unit

    fun getAllNote(): List<Note>
}