package org.softhk.mvp.presenter

import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.data.repository.ds.NoteDataSource
import org.softhk.mvp.ui.main.MainActivityContract

class NoteMainPresenter constructor(val view: MainActivityContract, val repository: Repository) :
    NoteMainPresenterContract {

    override fun getAllNote() {
        repository.getAllNote().let {list->
            view.setNotes(list)
        }
    }

    override fun addNote(note: Note) {
        repository.addNote(note)
    }

    override fun deleteNote(note: Note) {
        repository.deleteNote(note)
    }

}