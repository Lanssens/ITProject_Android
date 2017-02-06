package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("ALL")
public class ShippingAddressContainer {
    @SuppressWarnings("unused")
    @SerializedName("commonShipToAddress")
    @Expose
    private CommonShipToAddress commonShipToAddress;

    @SuppressWarnings("unused")
    public ShippingAddressContainer(CommonShipToAddress commonShipToAddress){
        this.commonShipToAddress = commonShipToAddress;
    }

    @SuppressWarnings("unused")
    public CommonShipToAddress getCommonShipToAddress() {
        return commonShipToAddress;
    }

    @SuppressWarnings("unused")
    public void setCommonShipToAddress(CommonShipToAddress commonShipToAddress) {
        this.commonShipToAddress = commonShipToAddress;
    }
}
