package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("unused")
public class InvoiceAddressContainer {
    @SerializedName("invoiceToAddress")
    @Expose
    private InvoiceAddress invoiceAddress;

    public InvoiceAddressContainer(){}

    public InvoiceAddressContainer(InvoiceAddress invoiceAddress){
        this.invoiceAddress = invoiceAddress;
    }

    public InvoiceAddress getInvoiceToAddress() {
        return invoiceAddress;
    }

    public void setInvoiceToAddress(InvoiceAddress invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }
}
