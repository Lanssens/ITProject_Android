package be.fenego.android_spotshop.models.searchHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nick on 26/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class HistoryItem {
    private String id;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("image_string")
    @Expose
    private String imageString;
    private Integer v;
    private List<String> tags = null;
    private String searchDate;

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @SuppressWarnings("unused")
    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    @SuppressWarnings("unused")
    public Integer getV() {
        return v;
    }

    @SuppressWarnings("unused")
    public void setV(Integer v) {
        this.v = v;
    }

    @SuppressWarnings("unused")
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @SuppressWarnings("unused")
    public String getSearchDate() {
        return searchDate;
    }

    @SuppressWarnings("unused")
    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }
}
