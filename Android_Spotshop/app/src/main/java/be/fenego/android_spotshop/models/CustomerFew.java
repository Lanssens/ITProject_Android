package be.fenego.android_spotshop.models;

/**
 * Created by Thijs on 1/13/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CustomerFew {

    @SuppressWarnings("unused")
    @SerializedName("customerNo")
    @Expose
    private String customerNo;
    @SuppressWarnings("unused")
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SuppressWarnings("unused")
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SuppressWarnings("unused")
    @SerializedName("email")
    @Expose
    private String email;
    @SuppressWarnings("unused")
    @SerializedName("preferredLanguage")
    @Expose
    private String preferredLanguage;
    @SuppressWarnings("unused")
    @SerializedName("phoneMobile")
    @Expose
    private String phoneMobile;


    @SuppressWarnings("unused")
    public String getCustomerNo() {
        return customerNo;
    }

    @SuppressWarnings("unused")
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
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
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        this.email = email;
    }

    @SuppressWarnings("unused")
    public String getPhoneMobile() {
        return phoneMobile;
    }

    @SuppressWarnings({"unused", "SillyAssignment"})
    public void setPhoneMobile(String email) {
        this.phoneMobile = phoneMobile;
    }

    @SuppressWarnings("unused")
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    @SuppressWarnings("unused")
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

}


