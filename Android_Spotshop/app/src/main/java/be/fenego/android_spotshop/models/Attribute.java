package be.fenego.android_spotshop.models;

import com.google.gson.annotations.*;

import java.io.Serializable;

/**
 * Created by Nick on 20/12/2016.
 */

public class Attribute implements Serializable {

    private String name;
    private String type;
    private Object value;


    public Attribute() {
    }


    public Attribute(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
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

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}