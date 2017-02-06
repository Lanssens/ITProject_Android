package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"unused", "DefaultFileTemplate"})
public class InvoiceAddressContainer {
    @SuppressWarnings("unused")
    @SerializedName("invoiceToAddress")
    @Expose
    private InvoiceAddress invoiceAddress;

    @SuppressWarnings("unused")
    public InvoiceAddressContainer(){}

    @SuppressWarnings("unused")
    public InvoiceAddressContainer(InvoiceAddress invoiceAddress){
        this.invoiceAddress = invoiceAddress;
    }

    @SuppressWarnings("unused")
    public InvoiceAddress getInvoiceToAddress() {
        return invoiceAddress;
    }

    @SuppressWarnings("unused")
    public void setInvoiceToAddress(InvoiceAddress invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }
}
