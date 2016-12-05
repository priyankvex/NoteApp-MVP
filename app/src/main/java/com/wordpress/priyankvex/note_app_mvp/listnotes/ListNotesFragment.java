package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesFragment extends Fragment implements ListNotesContract.View{

    public static ListNotesFragment newInstance() {
        return new ListNotesFragment();
    }

    public ListNotesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void notifyItemInserted(int position) {

    }

    @Override
    public void notiffyDataSetChanged() {

    }

    @Override
    public void notifyItemRemoved(int position) {

    }

    @Override
    public void setPresenter(ListNotesContract.Presenter presenter) {

    }
}
