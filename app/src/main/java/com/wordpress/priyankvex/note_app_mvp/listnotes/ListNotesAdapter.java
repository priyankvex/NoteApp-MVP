package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wordpress.priyankvex.note_app_mvp.R;

/**
 * Created by @priyankvex on 5/12/16.
 */

class ListNotesAdapter extends RecyclerView.Adapter<ListNotesAdapter.ViewHolder> {

    private ListNotesContract.Presenter mPresenter;

    ListNotesAdapter(ListNotesContract.Presenter presenter){
        this.mPresenter = presenter;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView bodyTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_textview);
            bodyTextView = (TextView) itemView.findViewById(R.id.body_textview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mPresenter.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mPresenter.bindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getNotesCount();
    }

}
