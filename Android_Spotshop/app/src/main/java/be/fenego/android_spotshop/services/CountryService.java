package be.fenego.android_spotshop.services;

import java.util.List;

import be.fenego.android_spotshop.models.Country;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Thijs on 6/01/2017.
 */

public interface CountryService {
    @GET("all")
    Call<List<Country>> getAllCountries();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

