package com.wordpress.priyankvex.note_app_mvp.viewnote;

import android.widget.EditText;

import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;

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

    }

    @Override
    public void setNoteData(EditText title, EditText body) {

    }

}
