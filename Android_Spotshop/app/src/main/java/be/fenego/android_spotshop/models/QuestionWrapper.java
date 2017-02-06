
package be.fenego.android_spotshop.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thijs on 6/01/2017.
 */

@SuppressWarnings({"DefaultFileTemplate", "unused"})
public class QuestionWrapper {

    @SuppressWarnings("unused")
    @SerializedName("elements")
    @Expose
    private List<Question> elements = null;
    @SuppressWarnings("unused")
    @SerializedName("type")
    @Expose
    private String type;
    @SuppressWarnings("unused")
    @SerializedName("name")
    @Expose
    private String name;

    @SuppressWarnings("unused")
    public List<Question> getElements() {
        return elements;
    }

    @SuppressWarnings("unused")
    public void setElements(List<Question> elements) {
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
