package be.fenego.android_spotshop.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nick on 23/12/2016.
 */

@SuppressWarnings({"ALL", "unused"})
public class ProductCollection implements Serializable {
    @SuppressWarnings("unused")
    private String pageable;
    @SuppressWarnings("unused")
    private Integer total;
    @SuppressWarnings("unused")
    private Integer offset;
    @SuppressWarnings("unused")
    private Integer amount;
    @SuppressWarnings("unused")
    private List<Element> elements = null;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private String name;

    @SuppressWarnings("unused")
    public String getPageable() {
        return pageable;
    }

    @SuppressWarnings("unused")
    public void setPageable(String pageable) {
        this.pageable = pageable;
    }

    @SuppressWarnings("unused")
    public Integer getTotal() {
        return total;
    }

    @SuppressWarnings("unused")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @SuppressWarnings("unused")
    public Integer getOffset() {
        return offset;
    }

    @SuppressWarnings("unused")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @SuppressWarnings("unused")
    public Integer getAmount() {
        return amount;
    }

    @SuppressWarnings("unused")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @SuppressWarnings("unused")
    public List<Element> getElements() {
        return elements;
    }

    @SuppressWarnings("unused")
    public void setElements(List<Element> elements) {
        this.elements = elements;
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
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }
}
