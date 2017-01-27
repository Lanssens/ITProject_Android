package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Thijs on 1/27/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasketOwner {

    @SerializedName("newOwnerAuthenticationToken")
    @Expose
    private String newOwnerAuthenticationToken;

    public String getNewOwnerAuthenticationToken() {
        return newOwnerAuthenticationToken;
    }

    public void setNewOwnerAuthenticationToken(String newOwnerAuthenticationToken) {
        this.newOwnerAuthenticationToken = newOwnerAuthenticationToken;
    }

}