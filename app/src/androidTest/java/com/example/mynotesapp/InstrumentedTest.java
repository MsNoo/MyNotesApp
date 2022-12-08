package com.example.mynotesapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.example.mynotesapp.Utils.removeExcessiveSpacesFromString;

//import android.support.test.rule.ActivityTestRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testWhenTextStringIsEnteredToCalculatorScreen() {
        final String givenString = "1  2  3";
        final String expectedResult = "1 2 3";
        final String withoutExcessiveSpaces = removeExcessiveSpacesFromString(givenString);

        onView(withId(R.id.addNewNoteBtn)).perform(click());
        onView(withId(R.id.descriptionInput)).perform(click(), replaceText(givenString));
        onView(withId(R.id.descriptionInput)).perform(click(), replaceText(withoutExcessiveSpaces));
        onView(withId(R.id.descriptionInput)).check(matches(withText(expectedResult)));
        onView(withId(R.id.saveBtn)).perform(click());
    }


}