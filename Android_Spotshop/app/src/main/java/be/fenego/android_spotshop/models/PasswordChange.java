package be.fenego.android_spotshop.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thijs on 1/12/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class PasswordChange {

    @SerializedName("password")
    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}