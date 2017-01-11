package be.fenego.android_spotshop.model;


import java.util.List;

/**
 * Created by Nick on 10/01/2017.
 */

public class ProductDetails {
    private String name;
    private String type;
    private List<Attribute> attributes = null;
    private String sku;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private Boolean availability;
    private Boolean retailSet;
    private Boolean inStock;
    private Boolean productMaster;
    private Boolean mastered;
    private String roundedAverageRating;
    private Integer readyForShipmentMin;
    private Integer readyForShipmentMax;
    private Integer minOrderQuantity;
    private Boolean productBundle;
    private String manufacturer;
   // private ListPrice listPrice;
    private SalePrice salePrice;
    private List<ShippingMethod> shippingMethods = null;
   /* private List<AvailableGiftWrap> availableGiftWraps = null;
    private List<AvailableGiftMessage> availableGiftMessages = null;*/
    private List<Image> images = null;

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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Boolean getRetailSet() {
        return retailSet;
    }

    public void setRetailSet(Boolean retailSet) {
        this.retailSet = retailSet;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean getProductMaster() {
        return productMaster;
    }

    public void setProductMaster(Boolean productMaster) {
        this.productMaster = productMaster;
    }

    public Boolean getMastered() {
        return mastered;
    }

    public void setMastered(Boolean mastered) {
        this.mastered = mastered;
    }

    public String getRoundedAverageRating() {
        return roundedAverageRating;
    }

    public void setRoundedAverageRating(String roundedAverageRating) {
        this.roundedAverageRating = roundedAverageRating;
    }

    public Integer getReadyForShipmentMin() {
        return readyForShipmentMin;
    }

    public void setReadyForShipmentMin(Integer readyForShipmentMin) {
        this.readyForShipmentMin = readyForShipmentMin;
    }

    public Integer getReadyForShipmentMax() {
        return readyForShipmentMax;
    }

    public void setReadyForShipmentMax(Integer readyForShipmentMax) {
        this.readyForShipmentMax = readyForShipmentMax;
    }

    public Integer getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Integer minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    public Boolean getProductBundle() {
        return productBundle;
    }

    public void setProductBundle(Boolean productBundle) {
        this.productBundle = productBundle;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /*public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }*/

    public SalePrice getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(SalePrice salePrice) {
        this.salePrice = salePrice;
    }

    public List<ShippingMethod> getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(List<ShippingMethod> shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

    /*public List<AvailableGiftWrap> getAvailableGiftWraps() {
        return availableGiftWraps;
    }

    public void setAvailableGiftWraps(List<AvailableGiftWrap> availableGiftWraps) {
        this.availableGiftWraps = availableGiftWraps;
    }

    public List<AvailableGiftMessage> getAvailableGiftMessages() {
        return availableGiftMessages;
    }

    public void setAvailableGiftMessages(List<AvailableGiftMessage> availableGiftMessages) {
        this.availableGiftMessages = availableGiftMessages;
    }*/

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Image getImageURLByName(String name){
        Image image = null;
        for(Image i : images){
            if(i.getName().equals(name)){
                image = i;
            }
        }
        return image;
    }
}
