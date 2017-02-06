
package be.fenego.android_spotshop.models.shoppingBasketModels;


@SuppressWarnings("unused")
public class ShippingMethod {

    private String name;
    private String type;
    private String id;
    private String description;
    private Integer shippingTimeMin;
    private Integer shippingTimeMax;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
