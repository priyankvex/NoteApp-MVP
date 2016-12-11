package com.wordpress.priyankvex.note_app_mvp.viewnote;

import android.widget.TextView;

import com.wordpress.priyankvex.note_app_mvp.BasePresenter;
import com.wordpress.priyankvex.note_app_mvp.BaseView;
import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;

/**
 * Created by @priyankvex on 8/12/16.
 */

public interface ViewNoteContract {

    interface View extends BaseView<Presenter>{

        void noteDeleted();
    }

    interface Presenter extends BasePresenter{

        void setModel(DataSourceContract model);
        void deleteNote();
        void setNoteData(TextView title, TextView body);
        void setNotePosition(int position);
    }
}
