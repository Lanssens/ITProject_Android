package be.fenego.android_spotshop;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import be.fenego.android_spotshop.menu.MenuActivity;

/**
 * Created by Thijs on 15/01/2017.
 */

@RunWith(AndroidJUnit4.class)
public class DrawerMenuTest {
    //Instrumented tests >
    //Cheatsheet
    //https://google.github.io/android-testing-support-library/docs/espresso/cheatsheet/index.html
    //https://google.github.io/android-testing-support-library/docs/index.html



    @Rule
    public ActivityTestRule<MenuActivity> menuActivityActivityTestRule =
            new ActivityTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void clickOnShopItem_loadsInNewFragment() throws Exception{
        //onView(withId(R.id.nav_first_fragment)).perform().check();
    }
}
