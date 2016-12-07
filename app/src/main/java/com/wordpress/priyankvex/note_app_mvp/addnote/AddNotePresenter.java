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
    private WeakReference<AddNoteContract.View> mView;
    // reference to the model
    private DataSourceContract mModel;

    AddNotePresenter(AddNoteContract.View view){
        this.mView = new WeakReference<>(view);
    }

    @Override
    public void onNewNoteClick() {
        // not needed
    }

    @Override
    public void saveNewNote(EditText title, EditText body) {
        String titleText = title.getText().toString();
        String bodyText = body.getText().toString();
        if (titleText.equals("")){
            mView.get().showToast(Toast.makeText(mView.get().getActivityContext(),
                    "Fill Title", Toast.LENGTH_SHORT));
            return;
        }
        if (bodyText.equals("")){
            mView.get().showToast(Toast.makeText(mView.get().getActivityContext(),
                    "Fill body", Toast.LENGTH_SHORT));
            return;
        }
        Note note = new Note();
        note.setText(bodyText);
        note.setTitle(titleText);
        boolean status = mModel.saveNewNote(note);
        if (status){
            // Note saved successfully
            mView.get().showToast(Toast.makeText(mView.get().getActivityContext(),
                    "Note Added", Toast.LENGTH_SHORT));
            mView.get().finishView();
        }
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
