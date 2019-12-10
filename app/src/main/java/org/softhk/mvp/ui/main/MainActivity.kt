package org.softhk.mvp.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.softhk.mvp.R
import org.softhk.mvp.contract.MainActivityPresenterContract
import org.softhk.mvp.data.entity.Note
import org.softhk.mvp.di.DaggerMVPExampleComponent
import org.softhk.mvp.di.MVPExampleComponent
import org.softhk.mvp.di.MVPExampleModule
import org.softhk.mvp.ui.main.adapter.NoteAdapter
import org.softhk.mvp.ui.main.adapter.RecyclerViewNoteListener
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityPresenterContract.view, View.OnClickListener,
    RecyclerViewNoteListener {

    @Inject
    lateinit var presenter: MainActivityPresenterContract.presenter

    private val rvAdapter by lazy { NoteAdapter(this) }
    private val recyclerView by lazy { rvNotes }

    //COMPONENTS UI
    private val editTextName by lazy { edittext_name }
    private val editTextDescription by lazy { edittext_description }
    private val buttonRegister by lazy { button_register }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDagger()
        setUpRecyclerView()

        buttonRegister.setOnClickListener(this)

        presenter.getAllNote()
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
                presenter.addNote(Note(name = textName, description = textDescription))
                    .apply {
                        clearUI()
                    }
            }
        }
    }

    override fun onNoteDeleteClick(noteToDelete: Note) {
        presenter.deleteNote(noteToDelete)
    }

    fun setUpDagger() {
        var mvpExampleComponent: MVPExampleComponent = DaggerMVPExampleComponent.builder()
            .mVPExampleModule(MVPExampleModule(application, this))
            .build()
        mvpExampleComponent.inject(this)
    }

    fun setUpRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = rvAdapter
    }

    fun clearUI() {
        editTextName.text.clear()
        editTextDescription.text.clear()
    }
}
