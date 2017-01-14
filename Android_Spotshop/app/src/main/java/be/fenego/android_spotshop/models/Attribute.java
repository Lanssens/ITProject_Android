package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 20/12/2016.
 */

@SuppressWarnings("DefaultFileTemplate")
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


// --Commented out by Inspection START (14/01/2017 16:26):
//    public Attribute(String name, String type, String value) {
//        this.name = name;
//        this.type = type;
//        this.value = value;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)

    public String getName() {
        return name;
    }

// --Commented out by Inspection START (14/01/2017 16:26):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)

    public String getType() {
        return type;
    }

// --Commented out by Inspection START (14/01/2017 16:26):
//    public void setType(String type) {
//        this.type = type;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)

    public Object getValue() {
        return value;
    }

// --Commented out by Inspection START (14/01/2017 16:26):
//    public void setValue(String value) {
//        this.value = value;
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)

}