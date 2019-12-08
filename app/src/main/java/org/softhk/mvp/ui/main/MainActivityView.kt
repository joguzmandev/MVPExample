package org.softhk.mvp.ui.main

import org.softhk.mvp.data.entity.Note

interface MainActivityView {

    fun fetchNotes()
    fun setNotes(listOfNotes: List<Note>)


}