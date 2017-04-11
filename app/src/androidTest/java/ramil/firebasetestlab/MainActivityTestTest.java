package ramil.firebasetestlab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTestTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void thenInputCorrectLoginWhenOpenUserActivity() throws Exception {
        onView(withId(R.id.login_tv)).perform(typeText("abc"));
        onView(withId(R.id.password_tv)).perform(typeText("abc"));
        onView(withId(R.id.login_btn)).perform(click());

        onView(withText(R.string.welcome)).check(matches(isDisplayed()));
    }

    @Test
    public void thenInputInCorrectLoginWhenStillOnMainActivity() throws Exception {
        onView(withId(R.id.login_tv)).perform(typeText("abc"));
        onView(withId(R.id.password_tv)).perform(typeText("cba"));
        onView(withId(R.id.login_btn)).perform(click());

        Thread.sleep(2000);
        onView(withId(R.id.login_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.password_tv)).check(matches(isDisplayed()));
    }
}
