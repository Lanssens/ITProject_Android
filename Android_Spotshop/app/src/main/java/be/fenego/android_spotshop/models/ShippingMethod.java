
package be.fenego.android_spotshop.models;


import java.io.Serializable;



/**
 * Created by Nick on 10/01/2017.
 */

@SuppressWarnings({"DefaultFileTemplate", "unused"})
public class ShippingMethod implements Serializable{

    @SuppressWarnings("unused")
    private String id;
    @SuppressWarnings("unused")
    private Integer shippingTimeMin;
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private Integer shippingTimeMax;

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public Integer getShippingTimeMin() {
        return shippingTimeMin;
    }

    @SuppressWarnings("unused")
    public void setShippingTimeMin(Integer shippingTimeMin) {
        this.shippingTimeMin = shippingTimeMin;
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

    @SuppressWarnings("unused")
    public Integer getShippingTimeMax() {
        return shippingTimeMax;
    }

    @SuppressWarnings("unused")
    public void setShippingTimeMax(Integer shippingTimeMax) {
        this.shippingTimeMax = shippingTimeMax;
    }

}
