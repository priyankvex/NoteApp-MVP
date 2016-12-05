package data;

import java.util.Calendar;

/**
 * Created by @priyankvex on 5/12/16.
 * Data model for the Note that will be saved
 */

public class Note {

    private String title;
    private String text;
    private long lastModified;

    public Note(){
        lastModified = Calendar.getInstance().getTimeInMillis();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getLastModified() {
        return lastModified;
    }
}
