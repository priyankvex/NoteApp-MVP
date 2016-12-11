package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.R;
import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;
import com.wordpress.priyankvex.note_app_mvp.data.Note;

import java.lang.ref.WeakReference;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesPresenter implements ListNotesContract.Presenter{


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
        ListNotesAdapter.ViewHolder viewHolder;
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list_custom_item,
                parent, false);
        itemRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListNotesView.get().onNoteClick(view);
            }
        });
        viewHolder = new ListNotesAdapter.ViewHolder(itemRow);
        return viewHolder;
    }

    @Override
    public void bindViewHolder(ListNotesAdapter.ViewHolder holder, int position) {

        final Note note = mDataSourceContract.getNote(position);
        holder.titleTextView.setText(note.getTitle());
        holder.bodyTextView.setText(note.getText());
    }

    @Override
    public int getNotesCount() {
        Log.d("test", "data size : " + mDataSourceContract.getNotesCount());
        return mDataSourceContract.getNotesCount();
    }

    @Override
    public void start() {
        // can be done in background task
        // not needed in this demo app
        mDataSourceContract.loadData();
        mListNotesView.get().notifyDataSetChanged();
    }
}
