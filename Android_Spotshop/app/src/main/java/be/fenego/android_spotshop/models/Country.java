
package be.fenego.android_spotshop.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thijs on 6/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class Country {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = null;
    @SerializedName("relevance")
    @Expose
    private String relevance;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("translations")
    @Expose
    private Translations translations;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("gini")
    @Expose
    private Double gini;
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    private List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("numericCode")
    @Expose
    private String numericCode;
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = null;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    @SuppressWarnings("unused")
    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    @SuppressWarnings("unused")
    public List<String> getCallingCodes() {
        return callingCodes;
    }

    @SuppressWarnings("unused")
    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @SuppressWarnings("unused")
    public List<String> getAltSpellings() {
        return altSpellings;
    }

    @SuppressWarnings("unused")
    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    @SuppressWarnings("unused")
    public Translations getTranslations() {
        return translations;
    }

    @SuppressWarnings("unused")
    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @SuppressWarnings("unused")
    public List<Double> getLatlng() {
        return latlng;
    }

    @SuppressWarnings("unused")
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

    @SuppressWarnings("unused")
    public List<String> getTimezones() {
        return timezones;
    }

    @SuppressWarnings("unused")
    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    @SuppressWarnings("unused")
    public List<String> getBorders() {
        return borders;
    }

    @SuppressWarnings("unused")
    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    @SuppressWarnings("unused")
    public List<String> getCurrencies() {
        return currencies;
    }

    @SuppressWarnings("unused")
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    @SuppressWarnings("unused")
    public List<String> getLanguages() {
        return languages;
    }

    @SuppressWarnings("unused")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
