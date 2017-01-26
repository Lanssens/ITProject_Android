package be.fenego.android_spotshop.Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.fenego.android_spotshop.models.PasswordChange;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class PasswordChangeTest {
    
    PasswordChange passwordChange;
    @Before
    public void setUp() {
        passwordChange = new PasswordChange();
    }


    @Test
    public void testSetAndGetPassword() {

        String value = "test";
        passwordChange.setPassword(value);
        String expectedValue = passwordChange.getPassword();

        assertEquals(expectedValue, value);
    }
    
}
