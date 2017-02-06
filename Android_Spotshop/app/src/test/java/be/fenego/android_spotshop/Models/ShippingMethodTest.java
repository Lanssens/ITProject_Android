package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.ShippingMethod;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class ShippingMethodTest {

    @SuppressWarnings("unused")
    private ShippingMethod shippingMethod;

    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        shippingMethod = new ShippingMethod();
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetName() {

        String value = "test";
        shippingMethod.setName(value);
        String expectedValue = shippingMethod.getName();

        assertEquals(value, expectedValue);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetType() {
        String value = "test";
        shippingMethod.setType(value);
        String expectedValue = shippingMethod.getType();

        assertEquals(value, expectedValue);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetId() {
        String value = "test";
        shippingMethod.setId(value);
        String expectedValue = shippingMethod.getId();

        assertEquals(value, expectedValue);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetShippingTimeMin() {

        int value = 50;
        shippingMethod.setShippingTimeMin(value);
        int expectedValue = shippingMethod.getShippingTimeMin();

        assertEquals(value, expectedValue);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetShippingTimeMax() {
        int value = 50;
        shippingMethod.setShippingTimeMax(value);
        int expectedValue = shippingMethod.getShippingTimeMax();

        assertEquals(value, expectedValue);
    }
}
