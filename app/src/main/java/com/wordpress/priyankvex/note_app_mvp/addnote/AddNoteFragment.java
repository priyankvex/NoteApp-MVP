package com.wordpress.priyankvex.note_app_mvp.addnote;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.wordpress.priyankvex.note_app_mvp.R;

/**
 * Created by @priyankvex on 6/12/16.
 */

public class AddNoteFragment extends Fragment implements AddNoteContract.View{

    private AddNoteContract.Presenter mPresenter;
    private EditText titleEditText;
    private EditText bodyEditText;

    public static AddNoteFragment newInstance() {
        return new AddNoteFragment();
    }

    public AddNoteFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_note_fragment, container, false);
        setUpViews(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_add_note, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_note){
            mPresenter.saveNewNote(titleEditText.getText().toString(), bodyEditText.getText().toString());
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViews(View rootView){
        titleEditText = (EditText) rootView.findViewById(R.id.title_edit_text);
        bodyEditText = (EditText) rootView.findViewById(R.id.body_edit_text);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getActivityContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void finishView() {
        getActivity().finish();
    }

    @Override
    public void setPresenter(AddNoteContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
