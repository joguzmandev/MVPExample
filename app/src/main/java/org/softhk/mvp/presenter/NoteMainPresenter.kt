package org.softhk.mvp.presenter

import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.contract.MainActivityPresenterContract

class NoteMainPresenter constructor(
    val view: MainActivityPresenterContract.view,
    val repository: Repository
) :
    MainActivityPresenterContract.presenter {

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