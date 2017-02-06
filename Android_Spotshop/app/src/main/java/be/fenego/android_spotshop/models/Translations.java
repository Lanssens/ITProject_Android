
package be.fenego.android_spotshop.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thijs on 6/01/2017.
 */


@SuppressWarnings({"DefaultFileTemplate", "unused"})
public class Translations {

    @SuppressWarnings("unused")
    @SerializedName("de")
    @Expose
    private String de;
    @SuppressWarnings("unused")
    @SerializedName("es")
    @Expose
    private String es;
    @SuppressWarnings("unused")
    @SerializedName("fr")
    @Expose
    private String fr;
    @SuppressWarnings("unused")
    @SerializedName("ja")
    @Expose
    private String ja;
    @SuppressWarnings("unused")
    @SerializedName("it")
    @Expose
    private String it;

    @SuppressWarnings("unused")
    public String getDe() {
        return de;
    }

    @SuppressWarnings("unused")
    public void setDe(String de) {
        this.de = de;
    }

    @SuppressWarnings("unused")
    public String getEs() {
        return es;
    }

    @SuppressWarnings("unused")
    public void setEs(String es) {
        this.es = es;
    }

    @SuppressWarnings("unused")
    public String getFr() {
        return fr;
    }

    @SuppressWarnings("unused")
    public void setFr(String fr) {
        this.fr = fr;
    }

    @SuppressWarnings("unused")
    public String getJa() {
        return ja;
    }

    @SuppressWarnings("unused")
    public void setJa(String ja) {
        this.ja = ja;
    }

    @SuppressWarnings("unused")
    public String getIt() {
        return it;
    }

    @SuppressWarnings("unused")
    public void setIt(String it) {
        this.it = it;
    }

}
