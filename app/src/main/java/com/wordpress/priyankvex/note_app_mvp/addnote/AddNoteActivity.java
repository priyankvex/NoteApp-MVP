package com.wordpress.priyankvex.note_app_mvp.addnote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.wordpress.priyankvex.note_app_mvp.R;
import com.wordpress.priyankvex.note_app_mvp.data.DataSource;

/**
 * Created by @priyankvex on 6/12/16.
 */

public class AddNoteActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);
        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Notes App");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AddNoteFragment addNoteFragment = (AddNoteFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (addNoteFragment== null){

            addNoteFragment = AddNoteFragment.newInstance();

            addFragmentToActivity(getSupportFragmentManager(),
                    addNoteFragment, R.id.contentFrame);
        }

        // Create the Presenter
        AddNotePresenter presenter = new AddNotePresenter(addNoteFragment);
        // Create the Model
        DataSource model = new DataSource();
        presenter.setModel(model);
        // set the presenter for the view
        addNoteFragment.setPresenter(presenter);

    }

    private void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
