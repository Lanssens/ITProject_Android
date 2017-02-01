package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"FieldCanBeLocal", "SameParameterValue"})
public class CommonShippingMethod {

    private String type;
    private String name;
    private Integer shippingTimeMax;
    private String id;
    private Integer shippingTimeMin;

    public  CommonShippingMethod(){

    }

    public CommonShippingMethod(String type, String name, String id, Integer min, Integer max){
        this.type = type;
        this.name = name;
        this.id = id;
        this.shippingTimeMin = min;
        this.shippingTimeMax = max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
