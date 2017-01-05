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
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.home.HomeActivity;
import be.fenego.android_spotshop.test.TestActivity;
import be.fenego.android_spotshop.login.LoginActivity;

/**
 * Created by Thijs on 12/22/2016.
 */

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);


        //If you want to change the content of header :3
        //View headerLayout = navigationView.getHeaderView(0);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);

        loadFragmentInContainer(TestActivity.class);
        changePersonalTabInMenu(false);


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

    public void changePersonalTabInMenu(boolean loggedIn){

        if(nvDrawer != null){
            nvDrawer.getMenu().findItem(R.id.nav_fourth_fragment).setVisible(loggedIn);
            nvDrawer.getMenu().findItem(R.id.nav_fifth_fragment).setVisible(loggedIn);
            nvDrawer.getMenu().findItem(R.id.nav_sixth_fragment).setVisible(loggedIn);
            nvDrawer.getMenu().findItem(R.id.nav_seventh_fragment).setVisible(!loggedIn);
        }




    }


    public void loadFragmentInContainer(Class fragmentClass){
        //Load in the right fragment
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(fragment!=null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
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
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
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

        }else{
            Toast.makeText(getApplicationContext(), "NavigationView is null", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onBackPressed() {
        // Disable going back to the SplashActivity
        moveTaskToBack(true);
    }
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_seventh_fragment:

                fragmentClass = LoginActivity.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = TestActivity.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = TestActivity.class;
                break;
            default:
                fragmentClass = TestActivity.class;
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