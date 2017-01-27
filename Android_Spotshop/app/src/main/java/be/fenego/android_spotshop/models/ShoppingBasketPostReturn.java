package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 19/01/2017.
 */

import java.io.Serializable;
@SuppressWarnings("ALL")
public class ShoppingBasketPostReturn implements Serializable {

    private String type;
    private String uri;
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
