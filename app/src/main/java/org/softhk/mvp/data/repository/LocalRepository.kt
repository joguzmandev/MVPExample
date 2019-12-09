package org.softhk.mvp.data.repository

import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource

class LocalRepository constructor(var noteLocalDataSource: NoteDataSource) : Repository {

    override fun addNote(note: Note) {
        noteLocalDataSource.addNote(note)
    }

    override fun findNoteById(id: Int): LiveData<Note> {
        return noteLocalDataSource.findNoteById(id)
    }

    override fun updateNote(note: Note) {
        noteLocalDataSource.updateNote(note)
    }

    override fun deleteNote(note: Note) {
        noteLocalDataSource.deleteNote(note)
    }

    override fun getAllNote(): LiveData<List<Note>> {
        return noteLocalDataSource.getAllNote()
    }
}