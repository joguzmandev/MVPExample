package org.softhk.mvp.data.repository.local

import android.os.AsyncTask
import android.util.Log
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource


class NoteLocalDataSource constructor(var noteDataBase: NoteDataBase) : NoteDataSource {

    override fun addNote(note: Note) {

        AsyncTask.execute { noteDataBase.noteDao().insertNote(note) }
    }

    override fun findNoteById(id: Int): Note {
        return noteDataBase.noteDao().findNoteById(id)
    }

    override fun updateNote(note: Note) {
        AsyncTask.execute { noteDataBase.noteDao().updateNote(note) }
    }

    override fun deleteNote(note: Note) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllNote(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}