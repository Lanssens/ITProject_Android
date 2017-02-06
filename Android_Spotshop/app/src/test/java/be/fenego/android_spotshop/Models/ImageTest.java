
package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Image;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class ImageTest {
    
    @SuppressWarnings("unused")
    private Image image;
    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        image = new Image();
    }
    


    @SuppressWarnings("unused")
    @Test
    public void testGetName() {

        String result = image.getName();
        assertNull(result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testGetEffectiveUrl() {

        String result = image.getEffectiveUrl();


        assertNull(result);
    }
    
}
