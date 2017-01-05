package be.fenego.android_spotshop.general;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;

import be.fenego.android_spotshop.services.LoginService;
import be.fenego.android_spotshop.models.User;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 3/01/2017.
 */

public class UserUtility {



    private static Activity currentAct;
    private static final String userCredentials = "UserDataSpotShop";

    public static boolean isUserLoggedIn(){
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        String silent = settings.getString("spotShopUsername", "");
        if(silent.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public static void removeUserCredentials(){
        currentAct.getSharedPreferences(userCredentials, 0).edit().clear().commit();
    }
    public static void retrieveUserCredentials(){
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        String username = settings.getString("spotShopUsername", "");
        String password = settings.getString("spotShopUsername", "");
    }

    public static void storeUserCredentials(String username, String password){

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("spotShopUsername", username);
        editor.putString("spotShopPassword", password);

        // Commit the edits!
        editor.commit();
    }

    public static void setCurrentAct(Activity currentAct) {
        UserUtility.currentAct = currentAct;
    }
    public static boolean loginUser(final Fragment currentFragment, final String username, final String password){

        LoginService loginService =
                ServiceGenerator.createService(LoginService.class, username, password);
        Call<User> call = loginService.getUserInformation();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    // User object available
                    storeUserCredentials( username, password);



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


