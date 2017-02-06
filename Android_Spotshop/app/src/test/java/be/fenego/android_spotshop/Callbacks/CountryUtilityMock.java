package be.fenego.android_spotshop.Callbacks;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.callbacks.CountryCallback;
import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.utilities.CountryUtility;

/**
 * Created by Thijs on 1/19/2017.
 */

@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate", "unused"})
public class CountryUtilityMock extends CountryUtility{
    @SuppressWarnings({"WeakerAccess", "unused"})
    static final List<Country> countries = new ArrayList<>();

    @SuppressWarnings("unused")
    public static void getAllCountries(final CountryCallback callback, boolean succeed){
        Country belgium = new Country();
        belgium.setName("Belgium");
        belgium.setAlpha2Code("BE_be");

        Country netherlands = new Country();
        belgium.setName("Netherlands");
        belgium.setAlpha2Code("NL_nl");

        countries.add(belgium);
        countries.add(netherlands);
        callback.onSuccessCountry(countries);
    }


}