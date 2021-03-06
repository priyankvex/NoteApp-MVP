package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.R;
import com.wordpress.priyankvex.note_app_mvp.viewnote.ViewNoteActivity;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesFragment extends Fragment implements ListNotesContract.View{

    private ListNotesContract.Presenter mPresenter;
    private ListNotesAdapter mAdapter;

    RecyclerView notesRecyclerView;

    public static ListNotesFragment newInstance() {
        return new ListNotesFragment();
    }

    public ListNotesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_notes_fragment, container, false);
        setUpViews(rootView);
        return rootView;
    }

    private void setUpViews(View rootView){
        notesRecyclerView = (RecyclerView) rootView.findViewById(R.id.notes_rv);
        mAdapter = new ListNotesAdapter(mPresenter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivityContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        notesRecyclerView.setLayoutManager(linearLayoutManager);
        notesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        notesRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void notifyItemInserted(int position) {
        mAdapter.notifyItemInserted(position);
    }

    @Override
    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void notifyItemRemoved(int position) {
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void onNoteClick(View view) {
        int position = notesRecyclerView.getChildLayoutPosition(view);
        Intent i = new Intent(getActivity(), ViewNoteActivity.class);
        i.putExtra("position", position);
        startActivity(i);
    }

    @Override
    public void setPresenter(ListNotesContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
