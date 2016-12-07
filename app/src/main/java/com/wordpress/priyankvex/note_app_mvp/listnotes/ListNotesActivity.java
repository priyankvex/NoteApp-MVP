package com.wordpress.priyankvex.note_app_mvp.listnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wordpress.priyankvex.note_app_mvp.R;
import com.wordpress.priyankvex.note_app_mvp.addnote.AddNoteActivity;
import com.wordpress.priyankvex.note_app_mvp.data.DataSource;

/**
 * Created by @priyankvex on 4/12/16.
 */

public class ListNotesActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_notes_activity);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Notes App");
        setSupportActionBar(toolbar);

        ListNotesFragment listNotesFragment = (ListNotesFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (listNotesFragment == null){

            listNotesFragment = ListNotesFragment.newInstance();

            addFragmentToActivity(getSupportFragmentManager(),
                    listNotesFragment, R.id.contentFrame);
        }

        // Create the Presenter
        ListNotesContract.Presenter presenter = new ListNotesPresenter(listNotesFragment);
        // Create the Model
        DataSource model = new DataSource();
        presenter.setModel(model);
        // set the presenter for the view
        listNotesFragment.setPresenter(presenter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.new_note_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListNotesActivity.this, AddNoteActivity.class);
                startActivity(i);
            }
        });
    }

    private void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
