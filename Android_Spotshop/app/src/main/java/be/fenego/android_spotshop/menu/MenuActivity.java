package be.fenego.android_spotshop.menu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import be.fenego.android_spotshop.R;
import be.fenego.android_spotshop.home.HomeActivity;
import be.fenego.android_spotshop.home.test;

/**
 * Created by Thijs on 12/22/2016.
 */

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Als je de content van de header wilt aanpassen:
        //View headerLayout = navigationView.getHeaderView(0);


        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        //Setup van de drawer
        setupDrawerContent(nvDrawer);

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

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = test.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = test.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = test.class;
                break;
            default:
                fragmentClass = test.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            Toast.makeText(getApplicationContext(), "Fragment created", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragmentManager!=null){
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }else{
            Toast.makeText(getApplicationContext(), "Fragmentmanager is null", Toast.LENGTH_SHORT).show();
        }


        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}