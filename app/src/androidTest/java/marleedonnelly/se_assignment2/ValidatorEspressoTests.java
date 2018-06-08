package marleedonnelly.se_assignment2;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ValidatorEspressoTests {
    @Before
    public void clearTextField() {
        onView(withId(R.id.passwordField)).perform(clearText());
    }

    @Test
    public void weakPassword() {
        onView(withId(R.id.passwordField)).perform(typeText("weak"), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.validatorView)).check(matches(withText("Please choose a stronger password.")));
    }
    @Test
    public void strongPassword() {
        onView(withId(R.id.passwordField)).perform(typeText("ItIsAMysT3Ry!!!!"), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.validatorView)).check(matches(withText("Password is acceptable.")));
    }
}



