package be.fenego.android_spotshop.Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.fenego.android_spotshop.models.Question;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class QuestionTest {
    
    private Question question;

    @Before
    public void setUp() {
        question = new Question();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testSetAndGetType() {

        String value = "test";
        question.setType(value);
        String expectedValue = question.getType();

        assertEquals(value, expectedValue);
    }

    @Test
    public void testSetAndGetKey() {


        String value = "test";
        question.setKey(value);
        String expectedValue = question.getKey();

        assertEquals(value, expectedValue);
    }

    @Test
    public void testSetAndGetText() {

        String value = "test";
        question.setText(value);
        String expectedValue = question.getText();

        assertEquals(value, expectedValue);
    }


}
