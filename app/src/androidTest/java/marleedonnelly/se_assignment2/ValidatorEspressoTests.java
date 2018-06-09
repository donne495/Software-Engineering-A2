package marleedonnelly.se_assignment2;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ValidatorEspressoTests {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void clearTextField() {
        onView(withId(R.id.passwordField)).perform(clearText());
    }

    @Test
    public void weakPassword() {
        onView(withId(R.id.passwordField)).perform(typeText("weak"), closeSoftKeyboard());
        onView(withId(R.id.validate)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password is not strong enough.")));
    }
    @Test
    public void strongPassword() {
        onView(withId(R.id.passwordField)).perform(typeText("ItIsAMysT3Ry!!!!"), closeSoftKeyboard());
        onView(withId(R.id.validate)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText("Password is strong enough.")));
    }
}



