package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
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

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesFragment extends Fragment implements ListNotesContract.View{

    private ListNotesContract.Presenter mPresenter;
    private ListNotesAdapter mAdapter;

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
        RecyclerView notesRecyclerView = (RecyclerView) rootView.findViewById(R.id.notes_rv);
        mAdapter = new ListNotesAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivityContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        notesRecyclerView.setAdapter(mAdapter);
        notesRecyclerView.setLayoutManager(linearLayoutManager);
        notesRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
    public void notiffyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void notifyItemRemoved(int position) {
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void setPresenter(ListNotesContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
