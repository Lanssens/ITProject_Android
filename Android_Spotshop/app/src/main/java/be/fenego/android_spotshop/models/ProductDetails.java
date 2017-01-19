package be.fenego.android_spotshop.models;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Nick on 10/01/2017.
 */

@SuppressWarnings({"unused", "DefaultFileTemplate", "CanBeFinal"})
public class ProductDetails implements Serializable {
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
    private final List<Image> images = null;

// --Commented out by Inspection START (14/01/2017 16:28):
//    public String getName() {
//        return name;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

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

// --Commented out by Inspection START (14/01/2017 16:28):
//    public String getSku() {
//        return sku;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setSku(String sku) {
//        this.sku = sku;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

// --Commented out by Inspection START (14/01/2017 16:28):
//    public String getShortDescription() {
//        return shortDescription;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

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

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Boolean getRetailSet() {
//        return retailSet;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setRetailSet(Boolean retailSet) {
//        this.retailSet = retailSet;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Boolean getInStock() {
//        return inStock;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setInStock(Boolean inStock) {
//        this.inStock = inStock;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Boolean getProductMaster() {
//        return productMaster;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setProductMaster(Boolean productMaster) {
//        this.productMaster = productMaster;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Boolean getMastered() {
//        return mastered;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setMastered(Boolean mastered) {
//        this.mastered = mastered;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

    public String getRoundedAverageRating() {
        return roundedAverageRating;
    }

    public void setRoundedAverageRating(String roundedAverageRating) {
        this.roundedAverageRating = roundedAverageRating;
    }

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Integer getReadyForShipmentMin() {
//        return readyForShipmentMin;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setReadyForShipmentMin(Integer readyForShipmentMin) {
//        this.readyForShipmentMin = readyForShipmentMin;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Integer getReadyForShipmentMax() {
//        return readyForShipmentMax;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setReadyForShipmentMax(Integer readyForShipmentMax) {
//        this.readyForShipmentMax = readyForShipmentMax;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Integer getMinOrderQuantity() {
//        return minOrderQuantity;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setMinOrderQuantity(Integer minOrderQuantity) {
//        this.minOrderQuantity = minOrderQuantity;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public Boolean getProductBundle() {
//        return productBundle;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setProductBundle(Boolean productBundle) {
//        this.productBundle = productBundle;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public String getManufacturer() {
//        return manufacturer;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setManufacturer(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

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

// --Commented out by Inspection START (14/01/2017 16:28):
//    public List<ShippingMethod> getShippingMethods() {
//        return shippingMethods;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setShippingMethods(List<ShippingMethod> shippingMethods) {
//        this.shippingMethods = shippingMethods;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

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

// --Commented out by Inspection START (14/01/2017 16:28):
//    public List<Image> getImages() {
//        return images;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

// --Commented out by Inspection START (14/01/2017 16:28):
//    public void setImages(List<Image> images) {
//        this.images = images;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:28)

    public Image getImageURLByName(String name){
        Image image = null;
        for(Image i : images != null ? images : null){
            if(i.getName().equals(name)){
                image = i;
            }
        }
        return image;
    }
}
