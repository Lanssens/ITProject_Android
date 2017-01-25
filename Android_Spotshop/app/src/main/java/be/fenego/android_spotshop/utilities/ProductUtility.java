package be.fenego.android_spotshop.utilities;


import android.widget.Toast;

import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.services.ProductService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nick on 13/01/2017.
 * utility voor het ophalen van producten uit de database.
 */

public class ProductUtility {
    private static final ProductService productService = ProductService.retrofit.create(ProductService.class);

    public static void getProductDetails(final ProductCallback callback, String SKU){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            productService.getProduct(SKU).enqueue(new Callback<ProductDetails>() {
                @Override
                public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                    callback.onSuccessGetProduct(response.body());
                }

                @Override
                public void onFailure(Call<ProductDetails> call, Throwable t) {
                   callback.onErrorGetProduct(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not display product details!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void getFeaturedProducts(final ProductCallback callback){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            productService.getFeaturedProducts().enqueue(new Callback<ProductCollection>() {
                @Override
                public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                    callback.onSuccessGetFeaturedProducts(response.body());
                }

                @Override
                public void onFailure(Call<ProductCollection> call, Throwable t) {
                    callback.onErrorGetFeaturedProducts(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not display product list!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void getProductsByImage(final ProductCallback callback, String annotationParameter){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            productService.getProductsByImage(annotationParameter).enqueue(new Callback<ProductCollection>() {
                @Override
                public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                   callback.onSuccessGetProductsByImage(response.body());
                }

                @Override
                public void onFailure(Call<ProductCollection> call, Throwable t) {
                    callback.onErrorGetProductsByImage(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not get products from image!",Toast.LENGTH_SHORT).show();
        }
    }

    public static void getProductByText(final ProductCallback callback,String input){
        android.support.v4.app.Fragment f =(android.support.v4.app.Fragment) callback;
        try{
            String result = "inSPIRED-inTRONICS-Site/-/products?attrs=image,roundedAverageRating,salePrice,availability&searchTerm=*";
            String[] separated = input.split(" ");
            for(String s : separated){
                result += s + "*";
            }
            productService.getProductsByText(result).enqueue(new Callback<ProductCollection>() {
                @Override
                public void onResponse(Call<ProductCollection> call, Response<ProductCollection> response) {
                    callback.onSuccessGetProductsByText(response.body());
                }

                @Override
                public void onFailure(Call<ProductCollection> call, Throwable t) {
                    callback.onErrorGetProductsByText(call, t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(f.getContext(),"Could not get products from database!",Toast.LENGTH_SHORT).show();
        }
    }
}
