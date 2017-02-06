
package be.fenego.android_spotshop.models;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class ShippingBucket implements Serializable {


    @SuppressWarnings("unused")
    private ShippingMethod shippingMethod;
    @SuppressWarnings("unused")
    private List<LineItem> lineItems = null;
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String type;

    @SuppressWarnings("unused")
    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    @SuppressWarnings("unused")
    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @SuppressWarnings("unused")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @SuppressWarnings("unused")
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
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
    public LineItem getLineItemByName(String name){
        for(LineItem lineItem : lineItems){
            if(lineItem.getTitle().equals(name)){
                return lineItem;
            }
        }
        return null;
    }

}
