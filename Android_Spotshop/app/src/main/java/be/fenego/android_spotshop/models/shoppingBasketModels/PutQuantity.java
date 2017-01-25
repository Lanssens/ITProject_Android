package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 25/01/2017.
 */

public class PutQuantity {
    private Quantity quantity;

    public PutQuantity(Quantity quantity){
        this.quantity = quantity;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
