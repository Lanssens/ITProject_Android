package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings({"unused", "DefaultFileTemplate"})
public class InvoiceAddress {

    @SuppressWarnings("unused")
    @SerializedName("type")
    @Expose
    private String type;
    @SuppressWarnings("unused")
    @SerializedName("state")
    @Expose
    private String state;
    @SuppressWarnings("unused")
    @SerializedName("country")
    @Expose
    private String country;
    @SuppressWarnings("unused")
    @SerializedName("city")
    @Expose
    private String city;
    @SuppressWarnings("unused")
    @SerializedName("street")
    @Expose
    private String street;
    @SuppressWarnings("unused")
    @SerializedName("street2")
    @Expose
    private String street2;
    @SuppressWarnings("unused")
    @SerializedName("street3")
    @Expose
    private String street3;
    @SuppressWarnings("unused")
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SuppressWarnings("unused")
    @SerializedName("phoneHome")
    @Expose
    private String phoneHome;
    @SuppressWarnings("unused")
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SuppressWarnings("unused")
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SuppressWarnings("unused")
    @SerializedName("title")
    @Expose
    private String title;
    @SuppressWarnings("unused")
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SuppressWarnings("unused")
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SuppressWarnings("unused")
    @SerializedName("phoneBusiness")
    @Expose
    private String phoneBusiness;
    @SuppressWarnings("unused")
    @SerializedName("email")
    @Expose
    private String email;
    @SuppressWarnings("unused")
    @SerializedName("addressName")
    @Expose
    private String addressName;

    @SuppressWarnings("unused")
    public InvoiceAddress(){}

    @SuppressWarnings("unused")
    public InvoiceAddress(String addressName, String email, String firstname, String lastname, String countryCode, String postalCode, String city, String street){
        this.type = "address";
        this.state = "";
        this.country = "";
        this.city = city;
        this.street = street;
        this.street2 = "";
        this.street3 = "";
        this.mobile = "";
        this.phoneHome = "";
        this.firstName = firstname;
        this.lastName = lastname;
        this.title = "";
        this.countryCode = countryCode;
        this.postalCode = postalCode;
        this.phoneBusiness = "";
        this.email = email;
        this.addressName = addressName;
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
    public String getState() {
        return state;
    }

    @SuppressWarnings("unused")
    public void setState(String state) {
        this.state = state;
    }

    @SuppressWarnings("unused")
    public String getCountry() {
        return country;
    }

    @SuppressWarnings("unused")
    public void setCountry(String country) {
        this.country = country;
    }

    @SuppressWarnings("unused")
    public String getCity() {
        return city;
    }

    @SuppressWarnings("unused")
    public void setCity(String city) {
        this.city = city;
    }

    @SuppressWarnings("unused")
    public String getStreet() {
        return street;
    }

    @SuppressWarnings("unused")
    public void setStreet(String street) {
        this.street = street;
    }

    @SuppressWarnings("unused")
    public String getStreet2() {
        return street2;
    }

    @SuppressWarnings("unused")
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @SuppressWarnings("unused")
    public String getStreet3() {
        return street3;
    }

    @SuppressWarnings("unused")
    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    @SuppressWarnings("unused")
    public String getMobile() {
        return mobile;
    }

    @SuppressWarnings("unused")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @SuppressWarnings("unused")
    public String getPhoneHome() {
        return phoneHome;
    }

    @SuppressWarnings("unused")
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public String getCountryCode() {
        return countryCode;
    }

    @SuppressWarnings("unused")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @SuppressWarnings("unused")
    public String getPostalCode() {
        return postalCode;
    }

    @SuppressWarnings("unused")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @SuppressWarnings("unused")
    public String getPhoneBusiness() {
        return phoneBusiness;
    }

    @SuppressWarnings("unused")
    public void setPhoneBusiness(String phoneBusiness) {
        this.phoneBusiness = phoneBusiness;
    }

    @SuppressWarnings("unused")
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        this.email = email;
    }

    @SuppressWarnings("unused")
    public String getAddressName() {
        return addressName;
    }

    @SuppressWarnings("unused")
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
