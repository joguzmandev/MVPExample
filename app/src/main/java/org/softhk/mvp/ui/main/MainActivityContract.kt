package org.softhk.mvp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.softhk.mvp.data.entity.Note

interface MainActivityContract {

    fun fetchNotes()
    fun setNotes(listOfNotes: LiveData<List<Note>>)


}