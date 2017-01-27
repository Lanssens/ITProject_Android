
package be.fenego.android_spotshop.models.shoppingBasketModels;


@SuppressWarnings("ALL")
public class Quantity {

    private String type;
    private Integer value;
    private String unit;

    public Quantity(){
    }

    public Quantity(Integer value){
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
