package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.BasePresenter;
import com.wordpress.priyankvex.note_app_mvp.BaseView;

/**
 * Created by @priyankvex on 4/12/16.
 */

public interface ListNotesContract {

    interface View extends BaseView<Presenter> {

        Context getApplicationContext();
        void notifyItemInserted(int position);
    }

    interface Presenter extends BasePresenter {

        int getNotesCount();
        ListNotesAdapter.ViewHolder createViewHolder(ViewGroup parent, int viewType);
        void bindViewHolder(ListNotesAdapter.ViewHolder viewHolder, int position);
    }
}
