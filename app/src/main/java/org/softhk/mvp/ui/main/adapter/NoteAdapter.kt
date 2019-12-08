package org.softhk.mvp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.softhk.mvp.R
import org.softhk.mvp.data.entity.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private lateinit var listNotesAdapter: ArrayList<Note>

    init {
        listNotesAdapter = ArrayList<Note>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_viewholder_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = listNotesAdapter.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note: Note = this.listNotesAdapter.get(position)
        holder.bind(note)
    }

    inner class NoteViewHolder constructor(var view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var textViewId: TextView
        private lateinit var textViewName: TextView
        private lateinit var textViewDescription: TextView


        init {
            textViewId = view.findViewById(R.id.tv_id)
            textViewName = view.findViewById(R.id.tv_name)
            textViewDescription = view.findViewById(R.id.tv_descrition)
        }

        fun bind(note: Note) {
            textViewId.text = note.id.toString()
            textViewName.text = note.name
            textViewDescription.text = note.description
        }
    }


    fun setAdapter(listAdapter: List<Note>) {
        this.listNotesAdapter.clear()
        this.listNotesAdapter.addAll(listAdapter)
        notifyDataSetChanged()
    }
}