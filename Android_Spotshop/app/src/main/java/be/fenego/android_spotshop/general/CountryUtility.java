package be.fenego.android_spotshop.general;

import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.services.CountryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 6/01/2017.
 */

public class CountryUtility {
    public static void getAllCountries(final CountryCallback callback){

        CountryService countryService = CountryService.retrofit.create(CountryService.class);
        final Call<List<Country>> call =
                countryService.getAllCountries();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful()){
                    callback.onSuccessCountry(response.body());
                }else{
                    callback.onCountryError();
                }


            }
            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                System.out.println(t.getMessage());
                callback.onCountryError();
            }
        });
    }
}
