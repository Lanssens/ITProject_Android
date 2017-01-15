package be.fenego.android_spotshop.general;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.models.Customer;
import be.fenego.android_spotshop.services.CustomerService;
import be.fenego.android_spotshop.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thijs on 3/01/2017.
 */

public class LoginUtility {



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
    public static List<String> retrieveUserCredentials(){
        List<String> userCreds = new ArrayList<String>();
        userCreds.clear();
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        userCreds.add(settings.getString("spotShopUsername", ""));
        userCreds.add(settings.getString("spotShopPassword", ""));
        userCreds.add(settings.getString("spotShopAuthToken", ""));
        return userCreds;
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
        LoginUtility.currentAct = currentAct;
    }
    public static boolean loginUser(final Fragment currentFragment, final String username, final String password){

        CustomerService customerService =
                ServiceGenerator.createService(CustomerService.class, username, password);
        Call<Customer> call = customerService.getUserInformation();

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                if (response.isSuccessful()) {

                    // User object available

                    System.out.println(response.headers().toString());
                    System.out.println(response.raw().headers().toString());
                    System.out.println(response.raw().code());

                    System.out.println(response.message());
                    removeUserCredentials();
                    storeUserCredentials(username, password);

                    //Get all headers
                    //Headers headers = response.headers();

                    //Get header value
                    //String cookie = response.headers().get("authentication-token");

                } else {
                    // Error response (kan unauthorized zijn)
                    // No implementation needed right now :c
                }
            }
            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                // Something went seriously wrong
                Log.d("Error", t.getMessage());
            }
        });
        return false;
    }

}


