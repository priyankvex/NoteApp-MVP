package com.wordpress.priyankvex.note_app_mvp.data;

/**
 * Created by @priyankvex on 5/12/16.
 */

public interface DataSourceContract {

    void onDestroy(boolean isChangingConfiguration);
    boolean loadData();
    Note getNote(int position);
    boolean deleteNote(Note note, int adapterPos);
    int getNotesCount();
    boolean saveNewNote(Note note);

}
