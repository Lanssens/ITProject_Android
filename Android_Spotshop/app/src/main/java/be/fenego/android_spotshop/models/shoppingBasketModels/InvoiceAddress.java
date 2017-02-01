package be.fenego.android_spotshop.models.shoppingBasketModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nick on 31/01/2017.
 */

@SuppressWarnings("unused")
public class InvoiceAddress {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("street2")
    @Expose
    private String street2;
    @SerializedName("street3")
    @Expose
    private String street3;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("phoneHome")
    @Expose
    private String phoneHome;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("phoneBusiness")
    @Expose
    private String phoneBusiness;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("addressName")
    @Expose
    private String addressName;

    public InvoiceAddress(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneBusiness() {
        return phoneBusiness;
    }

    public void setPhoneBusiness(String phoneBusiness) {
        this.phoneBusiness = phoneBusiness;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
