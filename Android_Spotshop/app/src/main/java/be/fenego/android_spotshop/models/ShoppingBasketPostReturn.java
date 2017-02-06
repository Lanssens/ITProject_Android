package be.fenego.android_spotshop.models;

/**
 * Created by Nick on 19/01/2017.
 */

import java.io.Serializable;
@SuppressWarnings({"ALL", "unused"})
public class ShoppingBasketPostReturn implements Serializable {

    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private String uri;
    @SuppressWarnings("unused")
    private String title;

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public void setType(String type) {
        this.type = type;
    }

    @SuppressWarnings("unused")
    public String getUri() {
        return uri;
    }

    @SuppressWarnings("unused")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }
}
