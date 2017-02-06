package be.fenego.android_spotshop.Models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Question;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class QuestionTest {
    
    @SuppressWarnings("unused")
    private Question question;

    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        question = new Question();
    }
    
    @SuppressWarnings({"EmptyMethod", "unused"})
    @After
    public void tearDown() {
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetType() {

        String value = "test";
        question.setType(value);
        String expectedValue = question.getType();

        assertEquals(value, expectedValue);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetKey() {


        String value = "test";
        question.setKey(value);
        String expectedValue = question.getKey();

        assertEquals(value, expectedValue);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetText() {

        String value = "test";
        question.setText(value);
        String expectedValue = question.getText();

        assertEquals(value, expectedValue);
    }


}
