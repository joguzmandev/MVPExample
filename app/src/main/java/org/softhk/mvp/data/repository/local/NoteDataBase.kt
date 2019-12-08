package org.softhk.mvp.data.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.softhk.mvp.data.entity.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}

object DB {

    private var INSTANCES: NoteDataBase? = null

    fun getInstance(context: Context): NoteDataBase {
        if (INSTANCES == null) {
            INSTANCES = Room.databaseBuilder(context, NoteDataBase::class.java, "DB2.db")
                .build()
        }
        return INSTANCES!!
    }
}