package org.softhk.mvp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.softhk.mvp.R
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.data.repository.Repository
import org.softhk.mvp.data.repository.local.DB
import org.softhk.mvp.data.repository.local.NoteDao
import org.softhk.mvp.data.repository.local.NoteDataBase
import org.softhk.mvp.data.repository.local.NoteLocalDataSource
import org.softhk.mvp.presenter.NotePresenter
import org.softhk.mvp.ui.main.adapter.NoteAdapter

class MainActivity : AppCompatActivity(), MainActivityView, View.OnClickListener {

    private lateinit var presenter: NotePresenter
    private lateinit var rvAdapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView

    //COMPONENTS UI
    private lateinit var editTextName: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonRegister: Button

    fun setUpRecyclerView() {
        rvAdapter = NoteAdapter()

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
        presenter = NotePresenter(
            this,
            Repository(NoteLocalDataSource(DB.getInstance(this)))
        )

        fetchNotes()
    }

    override fun fetchNotes() {
        presenter.getAllNote()
    }

    override fun setNotes(listOfNotes: List<Note>) {
        rvAdapter.setAdapter(listOfNotes)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_register -> {
                val textName = editTextName.text.toString()
                val textDescription = editTextDescription.text.toString()
                presenter.addNote(Note(name = textName, description = textDescription))
                clearUI()
            }
        }
    }
}
