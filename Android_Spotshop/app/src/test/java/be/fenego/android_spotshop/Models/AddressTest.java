package be.fenego.android_spotshop.Models;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.fenego.android_spotshop.models.Address;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
public class AddressTest {

    private Address instance;



    @Before
    public void setUp() {
        instance = new Address();
    }



    @Test
    public void testSetAndGetAddressName() {

        String expResult = "test";
        instance.setAddressName("test");
        String result = instance.getAddressName();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetEmail() {

        String expResult = "test";
        instance.setEmail("test");
        String result = instance.getEmail();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetFirstName() {

        String expResult = "test";
        instance.setFirstName("test");
        String result = instance.getFirstName();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetLastName() {

        String expResult = "test";
        instance.setLastName("test");
        String result = instance.getLastName();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetCountryCode() {

        String expResult = "test";
        instance.setCountryCode("test");
        String result = instance.getCountryCode();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetPostalCode() {

        String expResult = "test";
        instance.setPostalCode("test");
        String result = instance.getPostalCode();

        assertEquals(expResult, result);
    }


    @Test
    public void testSetAndGetCity() {

        String expResult = "test";
        instance.setCity("test");
        String result = instance.getCity();

        assertEquals(expResult, result);
    }

    @Test
    public void testSetAndGetStreet() {

        String expResult = "test";
        instance.setStreet("test");
        String result = instance.getStreet();

        assertEquals(expResult, result);
    }



}
