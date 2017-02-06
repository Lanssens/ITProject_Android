package be.fenego.android_spotshop.Callbacks;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

import be.fenego.android_spotshop.callbacks.CountryCallback;
import be.fenego.android_spotshop.models.Country;

/**
 * Created by Thijs on 1/19/2017.
 */

@SuppressWarnings({"DefaultFileTemplate", "unused"})
public class CountryCallbackTest implements CountryCallback{

    @SuppressWarnings("unused")
    CountryCallback countryCallback;

    @SuppressWarnings("unused")
    @Test
    public void getFeaturedProductsTestSucceed(){
        CountryUtilityMock.getAllCountries(this, true);
    }

    @SuppressWarnings("unused")
    @Test
    public void getFeaturedProductsTestFail(){
        CountryUtilityMock.getAllCountries(this, false);
    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessCountry(List<Country> countries) {
        Assert.assertNotNull(countries);
    }

    @SuppressWarnings("unused")
    @Override
    public void onCountryError() {
        Assert.assertTrue(true);
    }
}