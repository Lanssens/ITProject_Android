package be.fenego.android_spotshop;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.fenego.android_spotshop.menu.MenuActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Nick on 15/01/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
@RunWith(AndroidJUnit4.class)
public class HomeFragmentInstrumentedTest {

    @Rule
    public ActivityTestRule<MenuActivity> menuActivityActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void checkDetailFragmentCalled() throws Exception{
        //onView(withId(R.id.nav_first_fragment)).perform(click());
        onData(withId(R.id.productListView)).inAdapterView(withId(R.id.homeListViewListItem)).perform(click());
        onView(withId(R.id.fragment_activity_product_details)).check(matches(isDisplayed()));
    }
}
