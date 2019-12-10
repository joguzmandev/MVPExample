package org.softhk.mvp.contract

import androidx.lifecycle.LiveData
import org.softhk.mvp.data.entity.Note

interface MainActivityPresenterContract {

    interface view {

        fun setNotes(listOfNotes: LiveData<List<Note>>)
    }

    interface presenter {

        fun getAllNote(): Unit

        fun addNote(note: Note): Unit

        fun deleteNote(note: Note): Unit
    }
}