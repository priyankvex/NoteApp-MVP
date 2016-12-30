package com.wordpress.priyankvex.note_app_mvp.addnote;

import android.widget.EditText;

import com.wordpress.priyankvex.note_app_mvp.data.DataSourceContract;
import com.wordpress.priyankvex.note_app_mvp.data.Note;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by @priyankvex on 30/12/16.
 */
public class AddNotePresenterTest {

    @Mock
    private DataSourceContract mDataSource;

    @Mock
    private AddNoteContract.View mAddNoteView;

    private AddNotePresenter mAddNotePresenter;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mAddNotePresenter = new AddNotePresenter(mAddNoteView);
        mAddNotePresenter.setModel(mDataSource);
    }

    @Test
    public void onNewNoteClick() throws Exception {

    }

    @Test
    public void saveNewNote() throws Exception {
        mAddNotePresenter.saveNewNote("Title", "Body goes here");
        verify(mDataSource).saveNewNote(any(Note.class));
        verify(mAddNoteView).showToast("Note Added");
        verify(mAddNoteView).finishView();
    }

    @Test
    public void setModel() throws Exception {

    }

}