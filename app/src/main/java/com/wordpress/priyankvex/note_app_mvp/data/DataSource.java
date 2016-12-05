package com.wordpress.priyankvex.note_app_mvp.data;

import com.wordpress.priyankvex.note_app_mvp.listnotes.ListNotesContract;

/**
 * Created by @priyankvex on 5/12/16.
 */

public class DataSource implements DataSourceContract{


    ListNotesContract.Presenter mPresenter;

    public DataSource(ListNotesContract.Presenter presenter){
        this.mPresenter = presenter;
    }
    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public int insertNote(Note note) {
        return 0;
    }

    @Override
    public boolean loadData() {
        return false;
    }

    @Override
    public Note getNote(int position) {
        return null;
    }

    @Override
    public boolean deleteNote(Note note, int adapterPos) {
        return false;
    }

    @Override
    public int getNotesCount() {
        return 0;
    }
}
