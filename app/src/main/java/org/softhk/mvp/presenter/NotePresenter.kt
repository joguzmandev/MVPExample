package org.softhk.mvp.presenter

import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.ui.main.MainActivity

class NotePresenter constructor(val view: MainActivity, val repository: Repository) {

    fun getAllNote() {
        repository.getAllNote().let { list ->
            view.setNotes(list)
        }
    }

    fun addNote(note: Note) {
        repository.addNote(note)
        getAllNote()
    }
}