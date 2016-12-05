package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.BasePresenter;
import com.wordpress.priyankvex.note_app_mvp.BaseView;
import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;

/**
 * Created by @priyankvex on 4/12/16.
 */

public interface ListNotesContract {

    interface View extends BaseView<Presenter> {

        Context getActivityContext();
        void notifyItemInserted(int position);
        void notiffyDataSetChanged();
        void notifyItemRemoved(int position);
    }

    interface Presenter extends BasePresenter {

        void onDestroy(boolean isChangingConfiguration);
        void setView(View view);
        void setModel(DataSourceContract model);
        ListNotesAdapter.ViewHolder createViewHolder(ViewGroup parent, int viewType);
        void bindViewHolder(ListNotesAdapter.ViewHolder holder, int position);
        int getNotesCount();
    }
}
