
package be.fenego.android_spotshop.Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.fenego.android_spotshop.models.Image;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class ImageTest {
    
    Image image;
    @Before
    public void setUp() {
        image = new Image();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testGetName() {

        String result = image.getName();
        String expectedResult = null;

        assertEquals(expectedResult , result);
    }


    @Test
    public void testGetEffectiveUrl() {

        String result = image.getEffectiveUrl();
        String expectedResult = null;

        assertEquals(expectedResult , result);
    }
    
}
