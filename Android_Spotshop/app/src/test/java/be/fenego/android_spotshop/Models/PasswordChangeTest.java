package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.PasswordChange;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class PasswordChangeTest {
    
    @SuppressWarnings("unused")
    private PasswordChange passwordChange;
    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        passwordChange = new PasswordChange();
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPassword() {

        String value = "test";
        passwordChange.setPassword(value);
        String expectedValue = passwordChange.getPassword();

        assertEquals(expectedValue, value);
    }
    
}
