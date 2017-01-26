package be.fenego.android_spotshop.Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.fenego.android_spotshop.models.Credentials;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class CredentialsTest {
    
    private Credentials cred;
    @Before
    public void setUp() {
        cred = new Credentials();
    }


    @Test
    public void testGetLogin() {

        String expResult = "test";
        cred.setLogin(expResult);
        String result = cred.getLogin();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetPassword() {

        String expResult = "test";
        cred.setPassword(expResult);
        String result = cred.getPassword();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetSecurityQuestion() {

        String expResult = "test";
        cred.setSecurityQuestion(expResult);
        String result = cred.getSecurityQuestion();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetSecurityQuestionAnswer() {

        String expResult = "test";
        cred.setSecurityQuestionAnswer(expResult);
        String result = cred.getSecurityQuestionAnswer();
        assertEquals(expResult, result);
    }

    
}
