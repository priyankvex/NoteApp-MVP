package com.wordpress.priyankvex.note_app_mvp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.wordpress.priyankvex.note_app_mvp.listnotes.ListNotesActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.wordpress.priyankvex.note_app_mvp", appContext.getPackageName());
    }

    private Matcher<View> withItemText(final String itemText) {
        checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty");
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View item) {
                return allOf(
                        isDescendantOfA(isAssignableFrom(RecyclerView.class)),
                        withText(itemText)).matches(item);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is isDescendantOfA RV with text " + itemText);
            }
        };
    }

    @Rule
    public ActivityTestRule<ListNotesActivity> mNotesActivityTestRule =
            new ActivityTestRule<>(ListNotesActivity.class);

    @Test
    public void clickAddNoteButton_opensAddNoteUi() throws Exception {
        // Click on the add note button
        onView(withId(R.id.new_note_fab)).perform(click());
        // Check if the add note screen is displayed
        onView(withId(R.id.title_edit_text)).check(matches(isDisplayed()));
    }


    @Test
    public void addNoteToNotesList() throws Exception {
        String newNoteTitle = "12345";
        String newNoteDescription = "UI testing for Android";

        // Click on the add note button
        onView(withId(R.id.new_note_fab)).perform(click());

        // Add note title and description
        // Type new note title
        onView(withId(R.id.title_edit_text)).perform(typeText(newNoteTitle), closeSoftKeyboard());
        onView(withId(R.id.body_edit_text)).perform(typeText(newNoteDescription),
                closeSoftKeyboard()); // Type new note description and close the keyboard

        // Save the note
        onView(withId(R.id.action_add_note))
                .perform(click());

        // Scroll notes list to added note, by finding its description
        onView(withId(R.id.notes_rv)).perform(
                scrollTo(hasDescendant(withText(newNoteTitle))));

        // Verify note is displayed on screen
        onView(withItemText(newNoteTitle)).check(matches(isDisplayed()));
    }

    @Test
    public void deleteNote(){

        String newNoteTitle = "12345";

        // Scroll notes list to added note, by finding its description
        onView(withId(R.id.notes_rv)).perform(
                scrollTo(hasDescendant(withText(newNoteTitle))));

        onView(withId(R.id.notes_rv)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.text_view_title)).check(matches(withText(newNoteTitle)));

        onView(withId(R.id.action_delete_note)).perform(click());

    }

}
