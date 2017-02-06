
package be.fenego.android_spotshop.models.shoppingBasketModels;


@SuppressWarnings("unused")
public class Totals {

    private String name;
    private String type;
    private Total total;
    private ShippingTaxTotal shippingTaxTotal;
    private SalesTaxTotal salesTaxTotal;
    private ShippingTotal shippingTotal;

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

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public ShippingTaxTotal getShippingTaxTotal() {
        return shippingTaxTotal;
    }

    public void setShippingTaxTotal(ShippingTaxTotal shippingTaxTotal) {
        this.shippingTaxTotal = shippingTaxTotal;
    }

    public SalesTaxTotal getSalesTaxTotal() {
        return salesTaxTotal;
    }

    public void setSalesTaxTotal(SalesTaxTotal salesTaxTotal) {
        this.salesTaxTotal = salesTaxTotal;
    }

    public ShippingTotal getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(ShippingTotal shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

}
