package be.fenego.android_spotshop.utilities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;

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

@SuppressWarnings("DefaultFileTemplate")
public class LoginUtility {



    private static Activity currentAct;
    private static final String userCredentials = "UserDataSpotShop";

    public static boolean isUserLoggedIn(){
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        String silent = settings.getString("AT", "");
        return !silent.equals("");
    }
    public static void removeUserCredentials(){
        currentAct.getSharedPreferences(userCredentials, 0).edit().clear().commit();
    }


    public static String retrieveAuthToken(){

        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);

        String authToken = settings.getString("AT", "");
        return authToken;
    }
    public static void storeAuthToken(String token){
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("AT", token);

        // Commit the edits!
        editor.commit();
    }

    public static String retrieveAnonToken(){

        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);

        String anonToken = settings.getString("AnonT", "");
        return anonToken;
    }

    public static void storeAnonToken(String token){

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("AnonT", token);

        // Commit the edits!
        editor.commit();
    }

    public static String retrieveUsername(){

        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);

        String authToken = settings.getString("UN", "");
        return authToken;
    }
    public static void storeUserCredentials(String username, String authorizationtoken){

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        SharedPreferences.Editor editor = settings.edit();

        //String authorizationtoken = username +":" +password;
        // encode data on your side using BASE64
        /*byte[]   bytesEncoded = Base64.encodeBase64(authorizationtoken.getBytes());
        System.out.println("encoded value is " + new String(bytesEncoded ));
        authorizationtoken = new String(bytesEncoded );*/

        editor.putString("UN", username);
        editor.putString("AT", authorizationtoken);

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

                    System.out.println("---------");
                    System.out.println("Alle headers van response");
                    System.out.println("---------");
                    for(int i = 0; i < response.headers().size(); i++){
                        System.out.println(response.headers().value(i));
                    }

                    System.out.println("---------");
                    System.out.println("Alle headers van call");
                    System.out.println("---------");
                    for(int i = 0; i < call.request().headers().size(); i++){
                        System.out.println(call.request().headers().value(i));
                    }

                    System.out.println("---------");
                    System.out.println("Specific");
                    System.out.println("---------");
                    System.out.println(response.headers().get("authorization"));
                    System.out.println(response.headers().get("authentication-token"));






                    removeUserCredentials();
                    storeUserCredentials(username, response.headers().get("authentication-token"));

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


