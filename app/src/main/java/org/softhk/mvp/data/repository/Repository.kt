package org.softhk.mvp.data.repository

import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.data.repository.local.NoteLocalDataSource

class Repository constructor(val noteLocalDs: NoteLocalDataSource) : NoteDataSource {


    override fun addNote(note: Note) {
        noteLocalDs.addNote(note)
    }

    override fun findNoteById(id: Int): LiveData<Note> {
        return noteLocalDs.findNoteById(id)
    }

    override fun updateNote(note: Note) {
        noteLocalDs.updateNote(note)
    }

    override fun deleteNote(note: Note) {
        noteLocalDs.deleteNote(note)
    }

    override fun getAllNote(): LiveData<List<Note>> {
        return noteLocalDs.getAllNote()
    }
}