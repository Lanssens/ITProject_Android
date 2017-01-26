package be.fenego.android_spotshop.models;

import java.util.List;

/**
 * Created by Nick on 19/01/2017.
 */

@SuppressWarnings("ALL")
public class ShoppingBasket {
        private String id;
        private List<SalesTaxTotalsByTaxRate> salesTaxTotalsByTaxRate = null;
        private List<ShippingBucket> shippingBuckets = null;
        private Totals totals;
        private InvoiceToAddress invoiceToAddress;
        private String type;
        private Boolean multipleShippmentsSupported;
        private List<String> dynamicMessages = null;
        private CommonShipToAddress commonShipToAddress;
        private CommonShippingMethod commonShippingMethod;
        private List<ShippingTaxTotalsByTaxRate> shippingTaxTotalsByTaxRate = null;
        private String name;
        private String purchaseCurrency;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<SalesTaxTotalsByTaxRate> getSalesTaxTotalsByTaxRate() {
            return salesTaxTotalsByTaxRate;
        }

        public void setSalesTaxTotalsByTaxRate(List<SalesTaxTotalsByTaxRate> salesTaxTotalsByTaxRate) {
            this.salesTaxTotalsByTaxRate = salesTaxTotalsByTaxRate;
        }

        public List<ShippingBucket> getShippingBuckets() {
            return shippingBuckets;
        }

        public void setShippingBuckets(List<ShippingBucket> shippingBuckets) {
            this.shippingBuckets = shippingBuckets;
        }

        public Totals getTotals() {
            return totals;
        }

        public void setTotals(Totals totals) {
            this.totals = totals;
        }

        public InvoiceToAddress getInvoiceToAddress() {
            return invoiceToAddress;
        }

        public void setInvoiceToAddress(InvoiceToAddress invoiceToAddress) {
            this.invoiceToAddress = invoiceToAddress;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getMultipleShippmentsSupported() {
            return multipleShippmentsSupported;
        }

        public void setMultipleShippmentsSupported(Boolean multipleShippmentsSupported) {
            this.multipleShippmentsSupported = multipleShippmentsSupported;
        }

        public List<String> getDynamicMessages() {
            return dynamicMessages;
        }

        public void setDynamicMessages(List<String> dynamicMessages) {
            this.dynamicMessages = dynamicMessages;
        }

        public CommonShipToAddress getCommonShipToAddress() {
            return commonShipToAddress;
        }

        public void setCommonShipToAddress(CommonShipToAddress commonShipToAddress) {
            this.commonShipToAddress = commonShipToAddress;
        }

        public CommonShippingMethod getCommonShippingMethod() {
            return commonShippingMethod;
        }

        public void setCommonShippingMethod(CommonShippingMethod commonShippingMethod) {
            this.commonShippingMethod = commonShippingMethod;
        }

        public List<ShippingTaxTotalsByTaxRate> getShippingTaxTotalsByTaxRate() {
            return shippingTaxTotalsByTaxRate;
        }

        public void setShippingTaxTotalsByTaxRate(List<ShippingTaxTotalsByTaxRate> shippingTaxTotalsByTaxRate) {
            this.shippingTaxTotalsByTaxRate = shippingTaxTotalsByTaxRate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPurchaseCurrency() {
            return purchaseCurrency;
        }

        public void setPurchaseCurrency(String purchaseCurrency) {
            this.purchaseCurrency = purchaseCurrency;
        }
}
