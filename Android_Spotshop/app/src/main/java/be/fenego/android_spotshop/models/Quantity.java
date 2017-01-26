package be.fenego.android_spotshop.models;

/**
 * Created by Nick on 20/01/2017.
 */
@SuppressWarnings("ALL")
public class Quantity {
    private Integer value;

    public Quantity(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
