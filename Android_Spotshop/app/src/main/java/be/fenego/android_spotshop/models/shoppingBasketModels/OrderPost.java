package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"SameParameterValue", "unused"})
public class OrderPost {

    @SerializedName("basketID")
    @Expose
    private String basketID;
    @SerializedName("acceptTermsAndConditions")
    @Expose
    private String acceptTermsAndConditions;

    public OrderPost(){

    }

    public OrderPost(String basketID, String acceptTermsAndConditions){
        this.basketID = basketID;
        this.acceptTermsAndConditions = acceptTermsAndConditions;
    }

    public String getBasketID() {
        return basketID;
    }

    public void setBasketID(String basketID) {
        this.basketID = basketID;
    }

    public String getAcceptTermsAndConditions() {
        return acceptTermsAndConditions;
    }

    public void setAcceptTermsAndConditions(String acceptTermsAndConditions) {
        this.acceptTermsAndConditions = acceptTermsAndConditions;
    }
}
