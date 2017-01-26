package be.fenego.android_spotshop.Callbacks;

import java.util.ArrayList;
import java.util.List;

import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.SalePrice;

/**
 * Created by Nick on 14/01/2017.
 */
@SuppressWarnings({"unused", "DefaultFileTemplate"})
public class ProductUtilityMock {
    //detail
    static final Attribute a1 = new Attribute("Internal memory type","String","DDR3-SDRAM");
    static final Attribute a2 = new Attribute("Operating system architecture","String","64-bit");
    static final List<Attribute> attributes = new ArrayList<>();
    static final ProductDetails productDetails = new ProductDetails();


    //list
    static final ProductCollection productCollection = new ProductCollection();
    static final List<Element> elements = new ArrayList<>();
    static final Element e1 = new Element();
    static final Element e2 = new Element();
    static final List<Attribute> attributesp = new ArrayList<>();
    static final Attribute ap1 = new Attribute("image","String","/INTERSHOP/static/WFS/inSPIRED-inTRONICS-Site/-/inSPIRED/en_US/M/3934150-1725.jpg");
    static final Attribute ap2 = new Attribute("salePrice","ResourceAttribute", new SalePrice("Money",10,"USD"));
    static Attribute ap3 = new Attribute("availability","Boolean",true);


    public static void getProductDetails(final ProductCallback callback){
        attributes.add(a1);
        attributes.add(a2);
        productDetails.setAttributes(attributes);
        productDetails.setAvailability(true);
        productDetails.setLongDescription("longdescription");
        productDetails.setProductName("productname");
        productDetails.setRoundedAverageRating("5");
        productDetails.setSalePrice(new SalePrice("ProductPrice",10,"USD"));
       callback.onSuccessGetProduct(productDetails);
    }

    public static void getFeaturedProducts(final ProductCallback callback){
        setUp();
       callback.onSuccessGetFeaturedProducts(productCollection);
    }

    public static void getProductsByImage(final ProductCallback callback){
       setUp();
       callback.onSuccessGetProductsByImage(productCollection);
    }

    public static void getProductByText(final ProductCallback callback){
        setUp();
       callback.onSuccessGetProductsByText(productCollection);
    }

    private static void setUp(){
        attributesp.add(ap1);
        attributesp.add(ap2);
        e1.setAttributes(attributesp);
        e1.setTitle("testTitle");
        e1.setDescription("testDescription");
        e1.setType("testType");
        e1.setUri("testUri");
        e2.setAttributes(attributesp);
        e2.setTitle("testTitle");
        e2.setDescription("testDescription");
        e2.setType("testType");
        e2.setUri("testUri");
        elements.add(e1);
        elements.add(e2);
        productCollection.setElements(elements);
    }
}
