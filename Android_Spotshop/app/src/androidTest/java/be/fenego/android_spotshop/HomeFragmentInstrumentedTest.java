package be.fenego.android_spotshop;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.fenego.android_spotshop.menu.MenuActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
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
    public void checkProductListNotNull() throws Exception{
        onView(withId(R.id.searchButton)).perform(click());
        Assert.assertNotNull(R.id.productListView);
    }
}
