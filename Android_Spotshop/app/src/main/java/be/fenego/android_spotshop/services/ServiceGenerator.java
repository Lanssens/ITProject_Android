package be.fenego.android_spotshop.services;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Thijs on 3/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class ServiceGenerator {

    public static final String API_BASE_URL = "https://axesso.fenego.zone/INTERSHOP/rest/WFS/inSPIRED-inTRONICS-Site/-/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        httpClient = new OkHttpClient.Builder();
        return createService(serviceClass, null, null);
    }

    //With Basic Authentication
    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        System.out.println("In basic auth generator with " + username + " en " + password);
        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    System.out.println("Het zou moeten aangepast zijn");
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }



        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    //With token
    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        System.out.println("In token generator");
        if (authToken != null) {
            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            //FnswrmLnsuo=|oGMDTlKPIq1xuJxSiTjUHXlqcnMT7tabTgF6qmoGqyrf/iD63U2ylw==|s1b12c3e6a3dbf85a
                            //
                            .header("authentication-token",  authToken)
                            //.header("authentication-token", "lNiLUWaXNok=|JD85fRMzvsVX97n2F/gceKQl7C8us+KzzmJrD9tqhVx54m6KsGL9Yw==|s1b12c3e636cfd015")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
