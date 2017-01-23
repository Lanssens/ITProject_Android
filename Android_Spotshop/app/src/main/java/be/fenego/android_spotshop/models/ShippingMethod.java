
package be.fenego.android_spotshop.models;


import java.io.Serializable;

public class ShippingMethod implements Serializable{

    private String id;
    private Integer shippingTimeMin;
    private String name;
    private String type;
    private Integer shippingTimeMax;

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

    public Integer getShippingTimeMax() {
        return shippingTimeMax;
    }

    public void setShippingTimeMax(Integer shippingTimeMax) {
        this.shippingTimeMax = shippingTimeMax;
    }

}
