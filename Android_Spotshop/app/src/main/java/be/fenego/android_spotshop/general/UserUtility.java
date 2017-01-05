package be.fenego.android_spotshop.general;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 3/01/2017.
 */

public class UserUtility {
    public static boolean loggedIn = false;

    public static boolean loginUser(final Fragment currentFragment, String username, String password){

        LoginService loginService =
                ServiceGenerator.createService(LoginService.class, username, password);
        Call<User> call = loginService.getUserInformation();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    // User object available
                    loggedIn = true;

                } else {
                    // Error response (kan unauthorized zijn)
                    // No implementation needed right now :c
                }
            }


            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }
}
