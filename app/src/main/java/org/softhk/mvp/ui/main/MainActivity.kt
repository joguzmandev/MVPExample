package org.softhk.mvp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softhk.mvp.R
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.data.repository.local.DB
import org.softhk.mvp.data.repository.local.NoteLocalDataSource
import org.softhk.mvp.presenter.NoteMainPresenter
import org.softhk.mvp.ui.main.adapter.NoteAdapter
import org.softhk.mvp.ui.main.adapter.RecyclerViewNoteListener

class MainActivity : AppCompatActivity(), MainActivityView, View.OnClickListener,
    RecyclerViewNoteListener {

    private lateinit var mainPresenter: NoteMainPresenter
    private lateinit var rvAdapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView

    //COMPONENTS UI
    private lateinit var editTextName: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonRegister: Button

    fun setUpRecyclerView() {
        rvAdapter = NoteAdapter(this)

        recyclerView = findViewById(R.id.rvNotes)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = rvAdapter
    }

    fun setUpUI() {
        editTextName = findViewById(R.id.edittext_name)
        editTextDescription = findViewById(R.id.edittext_description)
        buttonRegister = findViewById(R.id.button_register)
        buttonRegister.setOnClickListener(this)
    }

    fun clearUI() {
        editTextName.text.clear()
        editTextDescription.text.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpUI()
        mainPresenter = NoteMainPresenter(
            this,
            Repository(NoteLocalDataSource(DB.getInstance(this)))
        )
        fetchNotes()
    }

    override fun fetchNotes() {
        mainPresenter.getAllNote()
    }

    override fun setNotes(listOfNotes: LiveData<List<Note>>) {
        listOfNotes.observe(this, Observer { list ->
            rvAdapter.setAdapter(list)
        })

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_register -> {
                val textName = editTextName.text.toString()
                val textDescription = editTextDescription.text.toString()
                mainPresenter.addNote(Note(name = textName, description = textDescription))
                    .apply {
                        clearUI()
                    }

            }
        }
    }

    override fun onNoteDeleteClick(noteToDelete: Note) {
        mainPresenter.deleteNote(noteToDelete)
        Toast.makeText(this, "Note selected to delete: ${noteToDelete}", Toast.LENGTH_LONG).show()
    }
}
