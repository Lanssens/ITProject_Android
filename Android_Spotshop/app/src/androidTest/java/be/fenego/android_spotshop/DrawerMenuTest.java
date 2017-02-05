package be.fenego.android_spotshop;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import be.fenego.android_spotshop.menu.MenuActivity;

/**
 * Created by Thijs on 15/01/2017.
 */

@RunWith(AndroidJUnit4.class)
public class DrawerMenuTest {
    @Rule
    public ActivityTestRule<MenuActivity> menuActivityActivityTestRule =
            new ActivityTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void clickOnShopItem_loadsInNewFragment() throws Exception{
        //onView(withId(R.id.nav_first_fragment)).perform().check();
    }
}
