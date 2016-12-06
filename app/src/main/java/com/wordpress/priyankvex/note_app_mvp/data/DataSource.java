package com.wordpress.priyankvex.note_app_mvp.data;

import com.wordpress.priyankvex.note_app_mvp.addnote.AddNoteContract;
import com.wordpress.priyankvex.note_app_mvp.listnotes.ListNotesContract;

import java.util.ArrayList;

/**
 * Created by @priyankvex on 5/12/16.
 */

public class DataSource<T> implements DataSourceContract{


    private T mPresenter;
    private ArrayList<Note> mNotes;

    public DataSource(T presenter){
        this.mPresenter = presenter;
    }


    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public int insertNote(Note note) {
        mNotes.add(note);
        return 1;
    }

    @Override
    public boolean loadData() {
        mNotes = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Note note = new Note();
            note.setTitle("Title Note " + i);
            note.setText("Lorem ipsum lorem ipsum.Lorem ipsum lorem ipsum. Lorem ipsum lorem ipsum");
            mNotes.add(note);
        }
        return true;
    }

    @Override
    public Note getNote(int position) {
        return mNotes.get(position);
    }

    @Override
    public boolean deleteNote(Note note, int adapterPos) {
        mNotes.remove(adapterPos);
        return true;
    }

    @Override
    public int getNotesCount() {
        return mNotes.size();
    }

    @Override
    public boolean saveNewNote(Note note) {
        return false;
    }
}
