package com.wordpress.priyankvex.note_app_mvp.addnote;

import android.widget.EditText;
import android.widget.Toast;

import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;
import com.wordpress.priyankvex.note_app_mvp.data.Note;

import java.lang.ref.WeakReference;

/**
 * Created by @priyankvex on 6/12/16.
 */

public class AddNotePresenter implements AddNoteContract.Presenter{

    // hold a weak reference to the view
    // because activity can be destroyed anytime
    private AddNoteContract.View mView;
    // reference to the model
    private DataSourceContract mModel;

    AddNotePresenter(AddNoteContract.View view){
        this.mView = view;
    }

    @Override
    public void onNewNoteClick() {
        // not needed
    }

    @Override
    public void saveNewNote(String title, String body) {
        if (title.equals("")){
            mView.showToast("Fill Title");
            return;
        }
        if (body.equals("")){
            mView.showToast("Fil Body");
            return;
        }
        Note note = new Note();
        note.setText(body);
        note.setTitle(title);
        mModel.saveNewNote(note);
        // Note saved successfully
        mView.showToast("Note Added");
        mView.finishView();
    }

    @Override
    public void setModel(DataSourceContract model) {
        this.mModel = model;
    }

    @Override
    public void start() {
        onNewNoteClick();
    }

}
