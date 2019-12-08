package org.softhk.mvp.data.repository.local

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource


class NoteLocalDataSource constructor(var noteDataBase: NoteDataBase) : NoteDataSource {

    override fun addNote(note: Note) {
        AsyncTask.execute { noteDataBase.noteDao().insertNote(note) }
    }

    override fun updateNote(note: Note) {
        AsyncTask.execute { noteDataBase.noteDao().updateNote(note) }
    }

    override fun deleteNote(note: Note) {
        AsyncTask.execute { noteDataBase.noteDao().deleteNote(note) }
    }

    override fun findNoteById(id: Int): LiveData<Note> {
        return noteDataBase.noteDao().findNoteById(id)
    }

    override fun getAllNote(): LiveData<List<Note>> {
        return noteDataBase.noteDao().getAllNotes()
    }


}