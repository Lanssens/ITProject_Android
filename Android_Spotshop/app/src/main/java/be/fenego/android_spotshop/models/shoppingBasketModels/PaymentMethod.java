package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("ALL")
public class PaymentMethod {
    @SuppressWarnings("unused")
    @SerializedName("name")
    @Expose
    private String name;
    @SuppressWarnings("unused")
    @SerializedName("type")
    @Expose
    private String type;


    @SuppressWarnings("unused")
    public PaymentMethod(){}

    @SuppressWarnings("unused")
    public PaymentMethod(String name, String type){
        this.name = name;
        this.type = type;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public void setType(String type) {
        this.type = type;
    }
}
