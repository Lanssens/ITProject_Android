
package be.fenego.android_spotshop.models;


import java.io.Serializable;

@SuppressWarnings("ALL")
public class CommonShippingMethod implements Serializable{

    private Integer shippingTimeMax;
    private String id;
    private Integer shippingTimeMin;
    private String name;
    private String type;
    private String description;

    public Integer getShippingTimeMax() {
        return shippingTimeMax;
    }

    public void setShippingTimeMax(Integer shippingTimeMax) {
        this.shippingTimeMax = shippingTimeMax;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
