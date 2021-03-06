package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 20/12/2016.
 */


@SuppressWarnings({"unused", "DefaultFileTemplate"})
public class Attribute implements Serializable {


    @SuppressWarnings("unused")
    private String name;

    @SuppressWarnings("unused")
    private String type;

    @SuppressWarnings("unused")
    private Object value;


// --Commented out by Inspection START (14/01/2017 16:26):
//    public Attribute() {
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)


    @SuppressWarnings("unused")
    public Attribute(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
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
    public Object getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(String value) {
        this.value = value;
    }

}