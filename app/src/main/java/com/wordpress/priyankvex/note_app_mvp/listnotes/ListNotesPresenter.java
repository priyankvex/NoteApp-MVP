package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;

import java.lang.ref.WeakReference;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesPresenter implements ListNotesContract.Presenter, DataSourceContract.LoadNotesCallbacks{


    // hold a weak reference to the view
    // because activity can be destroyed anytime
    private WeakReference<ListNotesContract.View> mListNotesView;
    // reference to the model
    private DataSourceContract mDataSourceContract;

    /**
     * Constructor to create the presenter
     * @param view reference to the view
     */
    public ListNotesPresenter(ListNotesContract.View view){
        this.mListNotesView = new WeakReference<>(view);
    }

    @Override
    public Context getApplicationContext() {
        return mListNotesView.get().getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return mListNotesView.get().getActivityContext();
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public void setView(ListNotesContract.View view) {
        mListNotesView = new WeakReference<>(view);
    }

    @Override
    public void setModel(DataSourceContract model) {
        this.mDataSourceContract = model;
    }

    @Override
    public ListNotesAdapter.ViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void bindViewHolder(ListNotesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getNotesCount() {
        return mDataSourceContract.getNotesCount();
    }

    @Override
    public void start() {
        // can be done in background task
        // not needed in this demo app
        mDataSourceContract.loadData();
    }
}
