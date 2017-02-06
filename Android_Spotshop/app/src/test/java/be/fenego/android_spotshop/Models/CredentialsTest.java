package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Credentials;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class CredentialsTest {
    
    @SuppressWarnings("unused")
    private Credentials cred;
    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        cred = new Credentials();
    }


    @SuppressWarnings("unused")
    @Test
    public void testGetLogin() {

        String expResult = "test";
        cred.setLogin(expResult);
        String result = cred.getLogin();
        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testGetPassword() {

        String expResult = "test";
        cred.setPassword(expResult);
        String result = cred.getPassword();
        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testGetSecurityQuestion() {

        String expResult = "test";
        cred.setSecurityQuestion(expResult);
        String result = cred.getSecurityQuestion();
        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testGetSecurityQuestionAnswer() {

        String expResult = "test";
        cred.setSecurityQuestionAnswer(expResult);
        String result = cred.getSecurityQuestionAnswer();
        assertEquals(expResult, result);
    }

    
}
