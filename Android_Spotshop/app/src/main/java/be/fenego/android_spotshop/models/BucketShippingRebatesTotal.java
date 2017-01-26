
package be.fenego.android_spotshop.models;


@SuppressWarnings("unused")
public class BucketShippingRebatesTotal {

    private String type;
    private Integer value;
    private String currencyMnemonic;

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

    public String getCurrencyMnemonic() {
        return currencyMnemonic;
    }

    public void setCurrencyMnemonic(String currencyMnemonic) {
        this.currencyMnemonic = currencyMnemonic;
    }

}
