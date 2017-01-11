package be.fenego.android_spotshop.general;

import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;

import be.fenego.android_spotshop.models.Country;
import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.models.Question;
import be.fenego.android_spotshop.models.QuestionWrapper;
import be.fenego.android_spotshop.services.CountryService;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.SecurityService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Thijs on 6/01/2017.
 */

public class CustomerUtility {
    public static void createUser(final Fragment currentFragment, final Customer customer){
        //TODO: Deze methode met een callback gebruiken ipv in activity
    }

    public static void getAllQuestions(final QuestionCallback callback){

        SecurityService securityService = SecurityService.retrofit.create(SecurityService.class);
        final Call<QuestionWrapper> call = securityService.getAllSecurityQuestions();

        call.enqueue(new Callback<QuestionWrapper>() {
            @Override
            public void onResponse(Call<QuestionWrapper> call, Response<QuestionWrapper> response) {

                callback.onSuccessQuestion(response.body().getElements());

            }
            @Override
            public void onFailure(Call<QuestionWrapper> call, Throwable t) {
                System.out.println(t.getMessage());
                callback.onError();
            }
        });
    }
}
