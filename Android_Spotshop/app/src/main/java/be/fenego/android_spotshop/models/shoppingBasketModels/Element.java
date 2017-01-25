
package be.fenego.android_spotshop.models.shoppingBasketModels;

import java.util.List;

public class Element {

    private String name;
    private String type;
    private String id;
    private Integer position;
    private ShippingMethod shippingMethod;
    private ShipToAddress shipToAddress;
    private Boolean variationProduct;
    private List<SalesTaxis> salesTaxes = null;
    private SingleBasePrice singleBasePrice;
    private Product product;
    private Price price;
    private Quantity quantity;
    private Totals totals;
    private Boolean isFreeGift;
    private Boolean availability;
    private Boolean isHiddenGift;
    private Boolean bundleProduct;
    private Boolean inStock;
    private String imageURL;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public ShipToAddress getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(ShipToAddress shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public Boolean getVariationProduct() {
        return variationProduct;
    }

    public void setVariationProduct(Boolean variationProduct) {
        this.variationProduct = variationProduct;
    }

    public List<SalesTaxis> getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(List<SalesTaxis> salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public SingleBasePrice getSingleBasePrice() {
        return singleBasePrice;
    }

    public void setSingleBasePrice(SingleBasePrice singleBasePrice) {
        this.singleBasePrice = singleBasePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Totals getTotals() {
        return totals;
    }

    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    public Boolean getIsFreeGift() {
        return isFreeGift;
    }

    public void setIsFreeGift(Boolean isFreeGift) {
        this.isFreeGift = isFreeGift;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Boolean getIsHiddenGift() {
        return isHiddenGift;
    }

    public void setIsHiddenGift(Boolean isHiddenGift) {
        this.isHiddenGift = isHiddenGift;
    }

    public Boolean getBundleProduct() {
        return bundleProduct;
    }

    public void setBundleProduct(Boolean bundleProduct) {
        this.bundleProduct = bundleProduct;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
