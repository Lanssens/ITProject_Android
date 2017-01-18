
package be.fenego.android_spotshop.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thijs on 6/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class Customer {

    @SerializedName("customerNo")
    @Expose
    private String customerNo;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("phoneHome")
    @Expose
    private String phoneHome;
    @SerializedName("phoneBusiness")
    @Expose
    private String phoneBusiness;
    @SerializedName("phoneMobile")
    @Expose
    private String phoneMobile;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("preferredLanguage")
    @Expose
    private String preferredLanguage;
    @SerializedName("credentials")
    @Expose
    private Credentials credentials;
    @SerializedName("address")
    @Expose
    private Address address;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneBusiness() {
        return phoneBusiness;
    }

    public void setPhoneBusiness(String phoneBusiness) {
        this.phoneBusiness = phoneBusiness;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
