package be.fenego.android_spotshop.utilities;

import android.util.Log;

import be.fenego.android_spotshop.models.searchHistory.HistoryItem;
import be.fenego.android_spotshop.services.HistoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nick on 26/01/2017.
 * Utility voor zoekgeschiedenis van afbeeldingen op te slaan in de back-end.
 */

public class SearchHistoryUtility {
    private static HistoryService historyService =  HistoryService.retrofit.create(HistoryService.class);

    public static void postSearchHistory(HistoryItem historyItem){
        historyService.postSearchHistory(historyItem).enqueue(new Callback<HistoryItem>() {
            @Override
            public void onResponse(Call<HistoryItem> call, Response<HistoryItem> response) {
                Log.v("Search History: "," Success post!");
                Log.v("Search History: ",Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<HistoryItem> call, Throwable t) {
                Log.v("search history: "," fail post!");
            }
        });
    }
}
