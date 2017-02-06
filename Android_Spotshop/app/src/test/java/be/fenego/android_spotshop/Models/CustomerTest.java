package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Address;
import be.fenego.android_spotshop.models.Credentials;
import be.fenego.android_spotshop.models.Customer;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class CustomerTest {
    
    @SuppressWarnings("unused")
    private Customer customer;

    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        customer = new Customer();
    }


    @SuppressWarnings("unused")
    @Test
    public void testCredentialsInCustomer() {
        Credentials credentials = new Credentials();
        credentials.setLogin("test");
        customer.setCredentials(credentials);
        String result = customer.getCredentials().getLogin();

        assertEquals(credentials.getLogin(), result);
    }
    @SuppressWarnings("unused")
    @Test
    public void testAddressInCustomer() {
        Address address = new Address();
        address.setAddressName("test");
        customer.setAddress(address);
        String result = customer.getAddress().getAddressName();

        assertEquals(address.getAddressName(), result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetCustomerNo() {

        String expResult = "";
        customer.setCustomerNo(expResult);
        String result = customer.getCustomerNo();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetTitle() {

        String expResult = "";
        customer.setTitle(expResult);
        String result = customer.getTitle();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetFirstName() {

        String expResult = "";
        customer.setFirstName(expResult);
        String result = customer.getFirstName();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetLastName() {
        String expResult = "";
        customer.setLastName(expResult);
        String result = customer.getLastName();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetBirthday() {
        String expResult = "";
        customer.setBirthday(expResult);
        String result = customer.getBirthday();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPhoneHome() {
        String expResult = "";
        customer.setPhoneHome(expResult);
        String result = customer.getPhoneHome();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPhoneBusiness() {
        String expResult = "";
        customer.setPhoneBusiness(expResult);
        String result = customer.getPhoneBusiness();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPhoneMobile() {
        String expResult = "";
        customer.setPhoneMobile(expResult);
        String result = customer.getPhoneMobile();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetFax() {
        String expResult = "";
        customer.setFax(expResult);
        String result = customer.getFax();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetEmail() {
        String expResult = "";
        customer.setPreferredLanguage(expResult);
        String result = customer.getPreferredLanguage();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPreferredLanguage() {
        String expResult = "";
        customer.setPreferredLanguage(expResult);
        String result = customer.getPreferredLanguage();

        assertEquals(expResult, result);
    }


}
