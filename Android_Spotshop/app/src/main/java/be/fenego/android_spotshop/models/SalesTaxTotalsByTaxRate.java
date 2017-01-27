
package be.fenego.android_spotshop.models;


import java.io.Serializable;
@SuppressWarnings("ALL")
public class SalesTaxTotalsByTaxRate implements Serializable {


    private Amount amount;
    private String name;
    private String type;
    private Integer rate;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
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
