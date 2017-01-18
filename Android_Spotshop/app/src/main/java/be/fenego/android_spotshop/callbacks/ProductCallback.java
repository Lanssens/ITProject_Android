package be.fenego.android_spotshop.callbacks;

import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import retrofit2.Call;

/**
 * Created by Nick on 13/01/2017.
 */

@SuppressWarnings({"UnusedParameters", "DefaultFileTemplate"})
public interface ProductCallback {

    void onSuccessGetProduct(ProductDetails productDetails);
    void onErrorGetProduct(Call<ProductDetails> call, Throwable t);

    void onSuccessGetFeaturedProducts(ProductCollection productCollection);
    void onErrorGetFeaturedProducts(Call<ProductCollection> call, Throwable t);

    void onSuccessGetProductsByImage(ProductCollection productCollection);
    void onErrorGetProductsByImage(Call<ProductCollection> call, Throwable t);

    void onSuccessGetProductsByText(ProductCollection productCollection);
    void onErrorGetProductsByText(Call<ProductCollection> call, Throwable t);
}
