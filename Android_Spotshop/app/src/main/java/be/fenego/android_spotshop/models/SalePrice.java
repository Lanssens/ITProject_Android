package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 29/12/2016.
 */

public class SalePrice implements Serializable{
    //type=Money, value=172.5, currencyMnemonic=USD
    String type;
    float value;
    String currencyMnemonic;

    public SalePrice(String type, float value, String currencyMnemonic) {
        this.type = type;
        this.value = value;
        this.currencyMnemonic = currencyMnemonic;
    }

    public String getCurrencyMnemonic() {
        return currencyMnemonic;
    }

    public void setCurrencyMnemonic(String currencyMnemonic) {
        this.currencyMnemonic = currencyMnemonic;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
