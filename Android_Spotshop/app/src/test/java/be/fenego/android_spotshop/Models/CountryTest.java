package be.fenego.android_spotshop.Models;

import org.junit.Before;
import org.junit.Test;

import be.fenego.android_spotshop.models.Country;

import static org.junit.Assert.*;

/**
 *
 * @author Thijs
 */
@SuppressWarnings("unused")
public class CountryTest {


    @SuppressWarnings("unused")
    private Country instance;
    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        instance = new Country();
    }

    /**
     * Test of getName method, of class Country.
     */
    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetName() {

        String expResult = "test";
        instance.setName(expResult);
        String result = instance.getName();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetAlpha2Code() {

        String expResult = "test";
        instance.setAlpha2Code(expResult);
        String result = instance.getAlpha2Code();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetAlpha3Code() {

        String expResult = "test";
        instance.setAlpha3Code(expResult);
        String result = instance.getAlpha3Code();

        assertEquals(expResult, result);
    }




    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetCapital() {

        String expResult = "test";
        instance.setCapital(expResult);
        String result = instance.getCapital();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetAltSpellings() {

        String expResult = "test";
        instance.setAlpha3Code(expResult);
        String result = instance.getAlpha3Code();

        assertEquals(expResult, result);
    }



    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetRelevance() {

        String expResult = "test";
        instance.setRelevance(expResult);
        String result = instance.getRelevance();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetRegion() {

        String expResult = "test";
        instance.setRegion(expResult);
        String result = instance.getRegion();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetSubregion() {

        String expResult = "test";
        instance.setSubregion(expResult);
        String result = instance.getSubregion();

        assertEquals(expResult, result);
    }



    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetPopulation() {

        int expResult = 500;
        instance.setPopulation(expResult);
        int result = instance.getPopulation();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetDemonym() {

        String expResult = "test";
        instance.setDemonym(expResult);
        String result = instance.getDemonym();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetArea() {

        Double expResult = 50.0;
        instance.setArea(expResult);
        Double result = instance.getArea();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetGini() {

        Double expResult = 50.0;
        instance.setGini(expResult);
        Double result = instance.getGini();

        assertEquals(expResult, result);
    }


    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetNativeName() {

        String expResult = "test";
        instance.setNativeName(expResult);
        String result = instance.getNativeName();

        assertEquals(expResult, result);
    }

    @SuppressWarnings("unused")
    @Test
    public void testSetAndGetNumericCode() {
        String expResult = "test";
        instance.setNumericCode(expResult);
        String result = instance.getNumericCode();

        assertEquals(expResult, result);
    }


   
    
}
