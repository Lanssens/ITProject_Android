package be.fenego.android_spotshop.models;

/**
 * Created by Nick on 10/01/2017.
 */
public class Image {
    private String name;
    private String type;
    private String effectiveUrl;
    private String viewID;
    private String typeID;
    private Integer imageActualHeight;
    private Integer imageActualWidth;
    private Boolean primaryImage;

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

    public String getEffectiveUrl() {
        return effectiveUrl;
    }

    public void setEffectiveUrl(String effectiveUrl) {
        this.effectiveUrl = effectiveUrl;
    }

    public String getViewID() {
        return viewID;
    }

    public void setViewID(String viewID) {
        this.viewID = viewID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public Integer getImageActualHeight() {
        return imageActualHeight;
    }

    public void setImageActualHeight(Integer imageActualHeight) {
        this.imageActualHeight = imageActualHeight;
    }

    public Integer getImageActualWidth() {
        return imageActualWidth;
    }

    public void setImageActualWidth(Integer imageActualWidth) {
        this.imageActualWidth = imageActualWidth;
    }

    public Boolean getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(Boolean primaryImage) {
        this.primaryImage = primaryImage;
    }

}
