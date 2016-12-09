package com.wordpress.priyankvex.note_app_mvp.data;

import java.util.List;

/**
 * Created by @priyankvex on 5/12/16.
 */

public class DataSource implements DataSourceContract{

    private List<Note> mNotes;

    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public boolean loadData() {
        String query = "SELECT * FROM note ORDER BY last_modified DESC";
        mNotes = Note.findWithQuery(Note.class, query);
        return true;
    }

    @Override
    public Note getNote(int position) {
        return mNotes.get(position);
    }

    @Override
    public boolean deleteNote(Note note) {
        note.delete();
        return true;
    }

    @Override
    public int getNotesCount() {
        return mNotes.size();
    }

    @Override
    public boolean saveNewNote(Note note) {
        note.save();
        return true;
    }
}
