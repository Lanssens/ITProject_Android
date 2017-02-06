package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 29/12/2016.
 */

@SuppressWarnings({"SameParameterValue", "CanBeFinal", "DefaultFileTemplate"})
public class SalePrice implements Serializable{
    //type=Money, value=172.5, currencyMnemonic=USD
    private String type;
    private float value;
    private String currencyMnemonic;

    public SalePrice(String type, float value, String currencyMnemonic) {
        this.type = type;
        this.value = value;
        this.currencyMnemonic = currencyMnemonic;
    }

    public String getCurrencyMnemonic() {
        return currencyMnemonic;
    }

// --Commented out by Inspection START (14/01/2017 16:29):
//    public void setCurrencyMnemonic(String currencyMnemonic) {
//        this.currencyMnemonic = currencyMnemonic;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:29)

    public float getValue() {
        return value;
    }

// --Commented out by Inspection START (14/01/2017 16:29):
//    public void setValue(float value) {
//        this.value = value;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:29)

    public String getType() {
        return type;
    }

// --Commented out by Inspection START (14/01/2017 16:29):
//    public void setType(String type) {
//        this.type = type;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:29)

}
