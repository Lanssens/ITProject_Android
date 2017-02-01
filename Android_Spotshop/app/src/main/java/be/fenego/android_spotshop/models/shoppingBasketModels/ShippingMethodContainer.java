package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("ALL")
public class ShippingMethodContainer {
    private String type;
    private CommonShippingMethod commonShippingMethod;

    public ShippingMethodContainer(CommonShippingMethod commonShippingMethod){
        this.commonShippingMethod = commonShippingMethod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CommonShippingMethod getCommonShippingMethod() {
        return commonShippingMethod;
    }

    public void setCommonShippingMethod(CommonShippingMethod commonShippingMethod) {
        this.commonShippingMethod = commonShippingMethod;
    }
}
