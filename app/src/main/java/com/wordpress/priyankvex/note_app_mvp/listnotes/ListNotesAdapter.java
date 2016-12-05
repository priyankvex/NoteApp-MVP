package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wordpress.priyankvex.note_app_mvp.R;

/**
 * Created by @priyankvex on 5/12/16.
 */

class ListNotesAdapter extends RecyclerView.Adapter<ListNotesAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView bodyTextView;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_textview);
            bodyTextView = (TextView) itemView.findViewById(R.id.body_textview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
