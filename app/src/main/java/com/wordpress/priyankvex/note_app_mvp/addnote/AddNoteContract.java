package com.wordpress.priyankvex.note_app_mvp.addnote;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.wordpress.priyankvex.note_app_mvp.BasePresenter;
import com.wordpress.priyankvex.note_app_mvp.BaseView;
import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;

/**
 * Created by @priyankvex on 6/12/16.
 */

public interface AddNoteContract {

    interface View extends BaseView<Presenter>{

        void showToast(String message);
        Context getActivityContext();
        void finishView();
    }

    interface Presenter extends BasePresenter{

        void onNewNoteClick();
        void saveNewNote(String title, String body);
        void setModel(DataSourceContract model);
    }
}
