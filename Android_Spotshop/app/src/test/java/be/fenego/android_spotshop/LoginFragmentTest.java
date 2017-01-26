/*
package be.fenego.android_spotshop;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.test.ApplicationTestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import be.fenego.android_spotshop.login.LoginFragment;
import be.fenego.android_spotshop.menu.MenuActivity;

import static org.junit.Assert.assertThat;

*/
/**
 * Created by Thijs on 1/20/2017.
 *//*


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class LoginFragmentTest extends ApplicationTestCase<Application> {

    public LoginFragmentTest() {
        super(Application.class);
    }
    MenuActivity menuActivity;
    LoginFragment loginFragment;

    @Before
    public void setUp() {
        menuActivity = Robolectric.setupActivity(MenuActivity.class);
        loginFragment = new LoginFragment();
        startFragment(loginFragment);
    }

    @Test
    public void testMenuActivity() {
        Assert.assertNotNull(menuActivity);
    }

    @Test
    public void testLoginFragment() {
        Assert.assertNotNull(loginFragment);
    }

    @Test
    public void testValidation() {
        assertTrue(loginFragment.validate());

    }

    private void startFragment( Fragment fragment ) {
        FragmentManager fragmentManager = menuActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null );
        fragmentTransaction.commit();
    }
}
*/
