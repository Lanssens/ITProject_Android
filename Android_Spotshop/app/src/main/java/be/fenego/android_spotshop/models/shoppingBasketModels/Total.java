
package be.fenego.android_spotshop.models.shoppingBasketModels;


@SuppressWarnings("ALL")
public class Total {

    private String type;
    private Double value;
    private String currencyMnemonic;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrencyMnemonic() {
        return currencyMnemonic;
    }

    public void setCurrencyMnemonic(String currencyMnemonic) {
        this.currencyMnemonic = currencyMnemonic;
    }

}
