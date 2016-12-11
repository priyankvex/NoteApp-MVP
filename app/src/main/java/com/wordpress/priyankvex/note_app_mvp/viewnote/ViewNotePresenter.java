package com.wordpress.priyankvex.note_app_mvp.viewnote;

import android.widget.TextView;

import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;
import com.wordpress.priyankvex.note_app_mvp.data.Note;

import java.lang.ref.WeakReference;

/**
 * Created by @priyankvex on 8/12/16.
 */

public class ViewNotePresenter implements ViewNoteContract.Presenter{


    // hold a weak reference to the view
    // because activity can be destroyed anytime
    private WeakReference<ViewNoteContract.View> mView;
    // reference to the model
    private DataSourceContract mModel;
    // position of the note
    private int position;

    ViewNotePresenter(ViewNoteContract.View view){
        this.mView = new WeakReference<>(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void setModel(DataSourceContract model) {
        this.mModel = model;
    }

    @Override
    public void deleteNote() {
        mModel.deleteNote(position);
        mView.get().noteDeleted();
    }

    @Override
    public void setNoteData(TextView title, TextView body) {
        Note note = mModel.getNote(position);
        title.setText(note.getTitle());
        body.setText(note.getText());
    }

    @Override
    public void setNotePosition(int position) {
        this.position = position;
    }

}
