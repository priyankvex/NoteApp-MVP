package com.wordpress.priyankvex.note_app_mvp.data;

import android.content.Context;

/**
 * Created by @priyankvex on 5/12/16.
 */

public interface DataSourceContract {

    void onDestroy(boolean isChangingConfiguration);
    int insertNote(Note note);
    boolean loadData();
    Note getNote(int position);
    boolean deleteNote(Note note, int adapterPos);
    int getNotesCount();

    public interface LoadNotesCallbacks {

        Context getApplicationContext();
        Context getActivityContext();
    }

}
