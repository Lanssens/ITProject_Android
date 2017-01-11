package be.fenego.android_spotshop.services;

import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.Question;
import be.fenego.android_spotshop.models.QuestionWrapper;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Thijs on 6/01/2017.
 */

public interface SecurityService {
    @GET("security/questions")
    Call<QuestionWrapper> getAllSecurityQuestions();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}