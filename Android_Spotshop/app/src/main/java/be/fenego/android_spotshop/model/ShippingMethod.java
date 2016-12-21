package be.fenego.android_spotshop.model;

import com.google.gson.annotations.*;

import java.io.Serializable;

/**
 * Created by Nick on 20/12/2016.
 */

public class ShippingMethod implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shippingTimeMin")
    @Expose
    private Integer shippingTimeMin;
    @SerializedName("shippingTimeMax")
    @Expose
    private Integer shippingTimeMax;


    public ShippingMethod() {
    }

    public ShippingMethod(String name, String type, String id, Integer shippingTimeMin, Integer shippingTimeMax) {
        super();
        this.name = name;
        this.type = type;
        this.id = id;
        this.shippingTimeMin = shippingTimeMin;
        this.shippingTimeMax = shippingTimeMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getShippingTimeMin() {
        return shippingTimeMin;
    }

    public void setShippingTimeMin(Integer shippingTimeMin) {
        this.shippingTimeMin = shippingTimeMin;
    }

    public Integer getShippingTimeMax() {
        return shippingTimeMax;
    }

    public void setShippingTimeMax(Integer shippingTimeMax) {
        this.shippingTimeMax = shippingTimeMax;
    }

}
