package org.softhk.mvp.data.repository.local

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.ds.NoteDataSource
import javax.inject.Inject


class NoteLocalDataSource constructor(var noteDao: NoteDao) : NoteDataSource {

    override fun addNote(note: Note) {
        AsyncTask.execute { noteDao.insertNote(note) }
    }

    override fun updateNote(note: Note) {
        AsyncTask.execute { noteDao.updateNote(note) }
    }

    override fun deleteNote(note: Note) {
        AsyncTask.execute { noteDao.deleteNote(note) }
    }

    override fun findNoteById(id: Int): LiveData<Note> {
        return noteDao.findNoteById(id)
    }

    override fun getAllNote(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }


}