
package be.fenego.android_spotshop.models;


@SuppressWarnings("ALL")
public class ShippingTaxTotalsByTaxRate {

    private Amount_ amount;
    private String name;
    private String type;
    private Integer rate;

    public Amount_ getAmount() {
        return amount;
    }

    public void setAmount(Amount_ amount) {
        this.amount = amount;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
