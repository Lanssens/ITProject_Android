
package be.fenego.android_spotshop.models;


import java.io.Serializable;

@SuppressWarnings("unused")
public class Amount implements Serializable{

    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private Double value;
    @SuppressWarnings("unused")
    private String currencyMnemonic;

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public void setType(String type) {
        this.type = type;
    }

    @SuppressWarnings("unused")
    public Double getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(Double value) {
        this.value = value;
    }

    @SuppressWarnings("unused")
    public String getCurrencyMnemonic() {
        return currencyMnemonic;
    }

    @SuppressWarnings("unused")
    public void setCurrencyMnemonic(String currencyMnemonic) {
        this.currencyMnemonic = currencyMnemonic;
    }

}
