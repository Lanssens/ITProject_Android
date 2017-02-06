
package be.fenego.android_spotshop.models;


import java.io.Serializable;
@SuppressWarnings({"ALL", "unused"})
class ShippingTaxTotalsByTaxRate implements Serializable {


    @SuppressWarnings("unused")
    private Amount_ amount;
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private Integer rate;

    @SuppressWarnings("unused")
    public Amount_ getAmount() {
        return amount;
    }

    @SuppressWarnings("unused")
    public void setAmount(Amount_ amount) {
        this.amount = amount;
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
    public Integer getRate() {
        return rate;
    }

    @SuppressWarnings("unused")
    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
