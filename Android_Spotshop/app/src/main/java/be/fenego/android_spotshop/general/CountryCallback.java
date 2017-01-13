package be.fenego.android_spotshop.general;

import java.util.List;

import be.fenego.android_spotshop.models.Country;

/**
 * Created by Thijs on 6/01/2017.
 */

public interface CountryCallback {
    void onSuccessCountry(List<Country> countries);
    void onCountryError();
}
