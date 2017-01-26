
package be.fenego.android_spotshop.models;

import java.util.List;

@SuppressWarnings("ALL")
public class ShippingBucket {

    private ShippingMethod shippingMethod;
    private List<LineItem> lineItems = null;
    private String name;
    private String type;

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
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

    public LineItem getLineItemByName(String name){
        for(LineItem lineItem : lineItems){
            if(lineItem.getTitle().equals(name)){
                return lineItem;
            }
        }
        return null;
    }

}
