package org.softhk.mvp.data.repository

import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.data.repository.local.NoteLocalDataSource

class Repository constructor(val noteLocalDs: NoteLocalDataSource) : NoteDataSource {


    override fun addNote(note: Note) {
        noteLocalDs.addNote(note)
    }

    override fun findNoteById(id: Int): Note {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(note: Note) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllNote(): List<Note> {
        return noteLocalDs.getAllNote()
    }
}