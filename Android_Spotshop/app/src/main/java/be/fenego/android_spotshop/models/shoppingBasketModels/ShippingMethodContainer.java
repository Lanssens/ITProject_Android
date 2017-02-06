package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("ALL")
public class ShippingMethodContainer {
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private CommonShippingMethod commonShippingMethod;

    @SuppressWarnings("unused")
    public ShippingMethodContainer(CommonShippingMethod commonShippingMethod){
        this.commonShippingMethod = commonShippingMethod;
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
    public CommonShippingMethod getCommonShippingMethod() {
        return commonShippingMethod;
    }

    @SuppressWarnings("unused")
    public void setCommonShippingMethod(CommonShippingMethod commonShippingMethod) {
        this.commonShippingMethod = commonShippingMethod;
    }
}
