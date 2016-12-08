package com.wordpress.priyankvex.note_app_mvp.viewnote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wordpress.priyankvex.note_app_mvp.R;

/**
 * Created by @priyankvex on 8/12/16.
 */

public class ViewNoteFragment extends Fragment implements ViewNoteContract.View{

    public static ViewNoteFragment newInstance() {
        return new ViewNoteFragment();
    }

    public ViewNoteFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_note_fragment, container, false);
        return rootView;
    }

    @Override
    public void setPresenter(ViewNoteContract.Presenter presenter) {

    }
}
