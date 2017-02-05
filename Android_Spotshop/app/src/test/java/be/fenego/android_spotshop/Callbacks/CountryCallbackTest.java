package be.fenego.android_spotshop.Callbacks;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

import be.fenego.android_spotshop.callbacks.CountryCallback;
import be.fenego.android_spotshop.models.Country;

/**
 * Created by Thijs on 1/19/2017.
 */

public class CountryCallbackTest implements CountryCallback{

    CountryCallback countryCallback;

    @Test
    public void getFeaturedProductsTestSucceed(){
        CountryUtilityMock.getAllCountries(this, true);
    }

    @Test
    public void getFeaturedProductsTestFail(){
        CountryUtilityMock.getAllCountries(this, false);
    }

    @Override
    public void onSuccessCountry(List<Country> countries) {
        Assert.assertNotNull(countries);
    }

    @Override
    public void onCountryError() {
        Assert.assertTrue(true);
    }
}