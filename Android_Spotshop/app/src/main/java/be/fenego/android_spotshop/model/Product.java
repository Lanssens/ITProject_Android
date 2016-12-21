package be.fenego.android_spotshop.model;

/**
 * Created by Nick on 20/12/2016.
 */

import com.google.gson.annotations.*;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("availability")
    @Expose
    private Boolean availability;
    @SerializedName("retailSet")
    @Expose
    private Boolean retailSet;
    @SerializedName("inStock")
    @Expose
    private Boolean inStock;
    @SerializedName("productMaster")
    @Expose
    private Boolean productMaster;
    @SerializedName("mastered")
    @Expose
    private Boolean mastered;
    @SerializedName("roundedAverageRating")
    @Expose
    private String roundedAverageRating;
    @SerializedName("readyForShipmentMin")
    @Expose
    private Integer readyForShipmentMin;
    @SerializedName("readyForShipmentMax")
    @Expose
    private Integer readyForShipmentMax;
    @SerializedName("minOrderQuantity")
    @Expose
    private Integer minOrderQuantity;
    @SerializedName("productBundle")
    @Expose
    private Boolean productBundle;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("shippingMethods")
    @Expose
    private List<ShippingMethod> shippingMethods = null;


    public Product() {
    }

    public Product(String name, String type, List<Attribute> attributes, String sku, String productName, String shortDescription, String longDescription, Boolean availability, Boolean retailSet, Boolean inStock, Boolean productMaster, Boolean mastered, String roundedAverageRating, Integer readyForShipmentMin, Integer readyForShipmentMax, Integer minOrderQuantity, Boolean productBundle, String manufacturer, String price, String currencyCode, List<ShippingMethod> shippingMethods) {
        super();
        this.name = name;
        this.type = type;
        this.attributes = attributes;
        this.sku = sku;
        this.productName = productName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.availability = availability;
        this.retailSet = retailSet;
        this.inStock = inStock;
        this.productMaster = productMaster;
        this.mastered = mastered;
        this.roundedAverageRating = roundedAverageRating;
        this.readyForShipmentMin = readyForShipmentMin;
        this.readyForShipmentMax = readyForShipmentMax;
        this.minOrderQuantity = minOrderQuantity;
        this.productBundle = productBundle;
        this.manufacturer = manufacturer;
        this.price = price;
        this.currencyCode = currencyCode;
        this.shippingMethods = shippingMethods;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<ShippingMethod> getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(List<ShippingMethod> shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

}