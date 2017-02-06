package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"SameParameterValue", "unused", "DefaultFileTemplate"})
public class OrderPost {

    @SuppressWarnings("unused")
    @SerializedName("basketID")
    @Expose
    private String basketID;
    @SuppressWarnings("unused")
    @SerializedName("acceptTermsAndConditions")
    @Expose
    private String acceptTermsAndConditions;

    @SuppressWarnings("unused")
    public OrderPost(){

    }

    @SuppressWarnings("unused")
    public OrderPost(String basketID, String acceptTermsAndConditions){
        this.basketID = basketID;
        this.acceptTermsAndConditions = acceptTermsAndConditions;
    }

    @SuppressWarnings("unused")
    public String getBasketID() {
        return basketID;
    }

    @SuppressWarnings("unused")
    public void setBasketID(String basketID) {
        this.basketID = basketID;
    }

    @SuppressWarnings("unused")
    public String getAcceptTermsAndConditions() {
        return acceptTermsAndConditions;
    }

    @SuppressWarnings("unused")
    public void setAcceptTermsAndConditions(String acceptTermsAndConditions) {
        this.acceptTermsAndConditions = acceptTermsAndConditions;
    }
}
