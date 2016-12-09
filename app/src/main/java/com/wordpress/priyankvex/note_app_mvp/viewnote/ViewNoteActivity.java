package com.wordpress.priyankvex.note_app_mvp.viewnote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.wordpress.priyankvex.note_app_mvp.R;
import com.wordpress.priyankvex.note_app_mvp.addnote.AddNotePresenter;
import com.wordpress.priyankvex.note_app_mvp.data.DataSource;

/**
 * Created by @priyankvex on 8/12/16.
 */

public class ViewNoteActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_note_activity);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("View Note");
        setSupportActionBar(toolbar);

        ViewNoteFragment viewNoteFragment = (ViewNoteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (viewNoteFragment == null){

            viewNoteFragment = ViewNoteFragment.newInstance();

            addFragmentToActivity(getSupportFragmentManager(),
                    viewNoteFragment, R.id.contentFrame);
        }

        // Create the Presenter
        ViewNotePresenter presenter = new ViewNotePresenter(viewNoteFragment);
        // Create the Model
        DataSource model = new DataSource();
        presenter.setModel(model);
        // set the presenter for the view
        viewNoteFragment.setPresenter(presenter);
    }

    private void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
