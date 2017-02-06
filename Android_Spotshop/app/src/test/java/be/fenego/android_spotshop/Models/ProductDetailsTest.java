
package be.fenego.android_spotshop.Models;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.ProductDetails;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class ProductDetailsTest {
    
    @SuppressWarnings("unused")
    private ProductDetails productDetails;

    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        productDetails = new ProductDetails();
    }
    

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetAttributes() {

        List<Attribute> expResult = null;
        List<Attribute> result = productDetails.getAttributes();
        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetProductName() {

        String value = "test";
        productDetails.setProductName(value);
        String expectedValue = productDetails.getProductName();

        assertEquals(value, expectedValue);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetLongDescription() {
        String value = "test";
        productDetails.setLongDescription(value);
        String expectedValue = productDetails.getLongDescription();

        assertEquals(value, expectedValue);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetAvailability() {
        productDetails.setAvailability(true);
        boolean expectedValue = productDetails.getAvailability();

        assertTrue(expectedValue);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetRoundedAverageRating() {
        String value = "test";
        productDetails.setRoundedAverageRating(value);
        String expectedValue = productDetails.getRoundedAverageRating();

        assertEquals(value, expectedValue);
    }



    
}
