package org.softhk.mvp.presenter

import org.softhk.mvp.data.entity.Note

interface NoteMainPresenterContract {
    fun getAllNote(): Unit

    fun addNote(note: Note): Unit

    fun deleteNote(note: Note): Unit
}