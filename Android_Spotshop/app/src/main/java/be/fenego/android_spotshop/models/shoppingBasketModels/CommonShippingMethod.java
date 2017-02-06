package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"FieldCanBeLocal", "SameParameterValue", "DefaultFileTemplate"})
public class CommonShippingMethod {

    private String type;
    private String name;
    @SuppressWarnings("unused")
    private Integer shippingTimeMax;
    private String id;
    @SuppressWarnings("unused")
    private Integer shippingTimeMin;

    @SuppressWarnings("unused")
    public  CommonShippingMethod(){

    }

    public CommonShippingMethod(String type, String name, String id, Integer min, Integer max){
        this.type = type;
        this.name = name;
        this.id = id;
        this.shippingTimeMin = min;
        this.shippingTimeMax = max;
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
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(String id) {
        this.id = id;
    }
}
