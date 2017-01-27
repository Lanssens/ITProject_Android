package be.fenego.android_spotshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.fenego.android_spotshop.models.searchHistory.HistoryItem;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Nick on 26/01/2017.
 * history service voor het posten van image zoekresultaten naar de back-end.
 */

public interface HistoryService {
    String BASE_URL ="http://vm6.tin.pxl.be:443/";

    @POST("searchhistory/")
    Call<HistoryItem> postSearchHistory(@Body HistoryItem historyItem);

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
