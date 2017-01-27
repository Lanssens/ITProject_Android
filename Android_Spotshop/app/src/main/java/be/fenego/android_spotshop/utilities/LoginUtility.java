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
        System.out.println("Removed user creds");
        currentAct.getSharedPreferences(userCredentials, 0).edit().clear().commit();
        SharedPreferences settings = currentAct.getSharedPreferences(userCredentials, 0);
        System.out.println(settings.getString("AT", "Empty AUTH token"));
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

        System.out.println("Stored AUTH token: " + token);
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

        settings = currentAct.getSharedPreferences(userCredentials, 0);
        System.out.println("Stored AUTH token: " + settings.getString("AT", ""));
    }

    public static void setCurrentAct(Activity currentAct) {
        LoginUtility.currentAct = currentAct;
    }
    public static boolean loginUser(final Fragment currentFragment, final String username, final String password){
        CustomerService customerService = null;
        System.out.println("Trying to log in with: " + username + "en" +  password);
        customerService = ServiceGenerator.createService(CustomerService.class, username, password);
        Call<Customer> call = customerService.getUserInformation();

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {

                System.out.println(response.code());
                System.out.println(call.request().url());
                for(int i = 0; i < call.request().headers().size(); i++){
                    call.request().headers().value(i);
                }
                System.out.println();

                if (response.isSuccessful()) {
                    //removeUserCredentials();
                    storeUserCredentials(username, response.headers().get("authentication-token"));

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


