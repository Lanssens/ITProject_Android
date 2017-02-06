package be.fenego.android_spotshop.models.shoppingBasketModels;

/**
 * Created by Nick on 25/01/2017.
 */

@SuppressWarnings("ALL")
public class PutQuantity {
    @SuppressWarnings("unused")
    private Quantity quantity;

    @SuppressWarnings("unused")
    public PutQuantity(Quantity quantity){
        this.quantity = quantity;
    }

    @SuppressWarnings("unused")
    public Quantity getQuantity() {
        return quantity;
    }

    @SuppressWarnings("unused")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
