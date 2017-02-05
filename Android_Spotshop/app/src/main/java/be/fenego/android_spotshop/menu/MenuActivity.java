package be.fenego.android_spotshop.menu;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.account.AccountFragment;
import be.fenego.android_spotshop.shoppingBasket.ShoppingBasketFragment;
import be.fenego.android_spotshop.utilities.LoginUtility;
import be.fenego.android_spotshop.home.HomeFragment;
import be.fenego.android_spotshop.login.LoginFragment;


/**
 * Created by Thijs on 12/22/2016.
 */

@SuppressWarnings("DefaultFileTemplate")
public class MenuActivity extends AppCompatActivity{
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    private Queue<android.support.v4.app.Fragment> fragments = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);


        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);

        loadFragmentInContainer(HomeFragment.class);

        //Fix the login logic of the application
        LoginUtility.setCurrentAct(this);
        changePersonalTabInMenu(LoginUtility.isUserLoggedIn());

    }

    //To check if user clicks outside of edittext > Closes keyboard as a result
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void changePersonalTabInMenu(boolean loggedIn) {

        if (nvDrawer != null) {
            nvDrawer.getMenu().findItem(R.id.nav_fourth_fragment).setVisible(loggedIn);
            //nvDrawer.getMenu().findItem(R.id.nav_fifth_fragment).setVisible(loggedIn);
            nvDrawer.getMenu().findItem(R.id.nav_sixth_fragment).setVisible(loggedIn);
            nvDrawer.getMenu().findItem(R.id.nav_seventh_fragment).setVisible(!loggedIn);
        }
    }


    public void loadFragmentInContainer(Class fragmentClass) {
        //Load in the right fragment
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            selectDrawerItem(menuItem);

                            return true;
                        }
                    });

        } else {
            Toast.makeText(getApplicationContext(), "NavigationView is null", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = ShoppingBasketFragment.class;
                break;

            case R.id.nav_fourth_fragment:
                fragmentClass = AccountFragment.class;
                break;
            case R.id.nav_sixth_fragment:
                LoginUtility.removeUserCredentials();
                Toast.makeText(getApplicationContext(), "Logged out succesfully.", Toast.LENGTH_SHORT).show();
                changePersonalTabInMenu(LoginUtility.isUserLoggedIn());

                fragmentClass = LoginFragment.class;
                break;
            case R.id.nav_seventh_fragment:

                fragmentClass = LoginFragment.class;
                break;


            default:
                fragmentClass = HomeFragment.class;
        }

        //Load in the appropriate fragment inside the container :)
        loadFragmentInContainer(fragmentClass);

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}