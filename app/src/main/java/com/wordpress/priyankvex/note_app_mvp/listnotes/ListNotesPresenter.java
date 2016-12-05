package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.view.ViewGroup;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesPresenter implements ListNotesContract.Presenter{


    @Override
    public int getNotesCount() {
        return 0;
    }

    @Override
    public ListNotesAdapter.ViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void bindViewHolder(ListNotesAdapter.ViewHolder viewHolder, int position) {

    }

    @Override
    public void start() {

    }
}
