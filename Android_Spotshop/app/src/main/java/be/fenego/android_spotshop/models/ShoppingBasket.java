package be.fenego.android_spotshop.models;

import java.io.Serializable;
import java.util.List;

import be.fenego.android_spotshop.models.shoppingBasketModels.CommonShipToAddress;

/**
 * Created by Nick on 19/01/2017.
 */

@SuppressWarnings({"ALL", "unused"})
public class ShoppingBasket implements Serializable{
        @SuppressWarnings("unused")
        private String id;
        @SuppressWarnings("unused")
        private List<SalesTaxTotalsByTaxRate> salesTaxTotalsByTaxRate = null;
        @SuppressWarnings("unused")
        private List<ShippingBucket> shippingBuckets = null;
        @SuppressWarnings("unused")
        private Totals totals;
        @SuppressWarnings("unused")
        private InvoiceToAddress invoiceToAddress;
        @SuppressWarnings("unused")
        private String type;
        @SuppressWarnings("unused")
        private Boolean multipleShippmentsSupported;
        @SuppressWarnings("unused")
        private List<String> dynamicMessages = null;
        @SuppressWarnings("unused")
        private CommonShipToAddress commonShipToAddress;
        @SuppressWarnings("unused")
        private CommonShippingMethod commonShippingMethod;
        @SuppressWarnings("unused")
        private List<ShippingTaxTotalsByTaxRate> shippingTaxTotalsByTaxRate = null;
        @SuppressWarnings("unused")
        private String name;
        @SuppressWarnings("unused")
        private String purchaseCurrency;

        @SuppressWarnings("unused")
        public String getId() {
            return id;
        }

        @SuppressWarnings("unused")
        public void setId(String id) {
            this.id = id;
        }

        @SuppressWarnings("unused")
        public List<SalesTaxTotalsByTaxRate> getSalesTaxTotalsByTaxRate() {
            return salesTaxTotalsByTaxRate;
        }

        @SuppressWarnings("unused")
        public void setSalesTaxTotalsByTaxRate(List<SalesTaxTotalsByTaxRate> salesTaxTotalsByTaxRate) {
            this.salesTaxTotalsByTaxRate = salesTaxTotalsByTaxRate;
        }

        @SuppressWarnings("unused")
        public List<ShippingBucket> getShippingBuckets() {
            return shippingBuckets;
        }

        @SuppressWarnings("unused")
        public void setShippingBuckets(List<ShippingBucket> shippingBuckets) {
            this.shippingBuckets = shippingBuckets;
        }

        @SuppressWarnings("unused")
        public Totals getTotals() {
            return totals;
        }

        @SuppressWarnings("unused")
        public void setTotals(Totals totals) {
            this.totals = totals;
        }

        @SuppressWarnings("unused")
        public InvoiceToAddress getInvoiceToAddress() {
            return invoiceToAddress;
        }

        @SuppressWarnings("unused")
        public void setInvoiceToAddress(InvoiceToAddress invoiceToAddress) {
            this.invoiceToAddress = invoiceToAddress;
        }

        @SuppressWarnings("unused")
        public String getType() {
            return type;
        }

        @SuppressWarnings("unused")
        public void setType(String type) {
            this.type = type;
        }

        @SuppressWarnings("unused")
        public Boolean getMultipleShippmentsSupported() {
            return multipleShippmentsSupported;
        }

        @SuppressWarnings("unused")
        public void setMultipleShippmentsSupported(Boolean multipleShippmentsSupported) {
            this.multipleShippmentsSupported = multipleShippmentsSupported;
        }

        @SuppressWarnings("unused")
        public List<String> getDynamicMessages() {
            return dynamicMessages;
        }

        @SuppressWarnings("unused")
        public void setDynamicMessages(List<String> dynamicMessages) {
            this.dynamicMessages = dynamicMessages;
        }

        @SuppressWarnings("unused")
        public CommonShipToAddress getCommonShipToAddress() {
            return commonShipToAddress;
        }

        @SuppressWarnings("unused")
        public void setCommonShipToAddress(CommonShipToAddress commonShipToAddress) {
            this.commonShipToAddress = commonShipToAddress;
        }

        @SuppressWarnings("unused")
        public CommonShippingMethod getCommonShippingMethod() {
            return commonShippingMethod;
        }

        @SuppressWarnings("unused")
        public void setCommonShippingMethod(CommonShippingMethod commonShippingMethod) {
            this.commonShippingMethod = commonShippingMethod;
        }

        @SuppressWarnings("unused")
        public List<ShippingTaxTotalsByTaxRate> getShippingTaxTotalsByTaxRate() {
            return shippingTaxTotalsByTaxRate;
        }

        @SuppressWarnings("unused")
        public void setShippingTaxTotalsByTaxRate(List<ShippingTaxTotalsByTaxRate> shippingTaxTotalsByTaxRate) {
            this.shippingTaxTotalsByTaxRate = shippingTaxTotalsByTaxRate;
        }

        @SuppressWarnings("unused")
        public String getName() {
            return name;
        }

        @SuppressWarnings("unused")
        public void setName(String name) {
            this.name = name;
        }

        @SuppressWarnings("unused")
        public String getPurchaseCurrency() {
            return purchaseCurrency;
        }

        @SuppressWarnings("unused")
        public void setPurchaseCurrency(String purchaseCurrency) {
            this.purchaseCurrency = purchaseCurrency;
        }
}
