
package be.fenego.android_spotshop.models.shoppingBasketModels;


@SuppressWarnings("ALL")
public class Quantity {

    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private Integer value;
    @SuppressWarnings("unused")
    private String unit;

    @SuppressWarnings("unused")
    public Quantity(){
    }

    @SuppressWarnings("unused")
    public Quantity(Integer value){
        this.value = value;
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
    public Integer getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(Integer value) {
        this.value = value;
    }

    @SuppressWarnings("unused")
    public String getUnit() {
        return unit;
    }

    @SuppressWarnings("unused")
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
