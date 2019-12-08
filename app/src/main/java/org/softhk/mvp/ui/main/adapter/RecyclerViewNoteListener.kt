package org.softhk.mvp.ui.main.adapter

import org.softhk.mvp.data.entity.Note

interface RecyclerViewNoteListener {
    fun onNoteDeleteClick(noteToDelete:Note)
}