package be.fenego.android_spotshop.Callbacks;
import org.junit.Test;
import java.util.List;
import be.fenego.android_spotshop.callbacks.ProductCallback;
import be.fenego.android_spotshop.models.Attribute;
import be.fenego.android_spotshop.models.Element;
import be.fenego.android_spotshop.models.ProductCollection;
import be.fenego.android_spotshop.models.ProductDetails;
import be.fenego.android_spotshop.models.SalePrice;
import retrofit2.Call;


/**
 * Created by Nick on 14/01/2017.
 */

@SuppressWarnings({"ALL", "unused"})
public class ProductCallbackTest implements ProductCallback {

    @SuppressWarnings("unused")
    ProductCallback productCallback;

    @SuppressWarnings("unused")
    @Test
    public void getFeaturedProductsTest(){
        ProductUtilityMock.getFeaturedProducts(this);
    }

    @SuppressWarnings("unused")
    @Test
    public void getProductDetailsTest(){
        ProductUtilityMock.getProductDetails(this);
    }

    @SuppressWarnings("unused")
    @Test
    public void getProductsByTextTest(){
        ProductUtilityMock.getProductByText(this);
    }


    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetProduct(ProductDetails productDetails) {
        SalePrice checkDetail = new SalePrice("ProductPrice",10,"USD");
        List<Attribute> attributes = productDetails.getAttributes();
        junit.framework.Assert.assertEquals(productDetails.getProductName(),"productname");
        junit.framework.Assert.assertEquals(productDetails.getLongDescription(),"longdescription");
        junit.framework.Assert.assertTrue(productDetails.getAvailability());
        junit.framework.Assert.assertEquals(productDetails.getRoundedAverageRating(),"5");
        junit.framework.Assert.assertEquals(productDetails.getSalePrice().getType(),checkDetail.getType());
        junit.framework.Assert.assertEquals(productDetails.getSalePrice().getCurrencyMnemonic(),checkDetail.getCurrencyMnemonic());
        junit.framework.Assert.assertEquals(productDetails.getSalePrice().getValue(),checkDetail.getValue());

        for(Attribute a : attributes){
            switch (a.getName()){
                case "Internal memory type":
                    junit.framework.Assert.assertEquals(a.getType(),"String");
                    junit.framework.Assert.assertEquals(a.getName(),"Internal memory type");
                    junit.framework.Assert.assertEquals(a.getValue(),"DDR3-SDRAM");
                    break;
                case "Operating system architecture":
                    junit.framework.Assert.assertEquals(a.getType(),"String");
                    junit.framework.Assert.assertEquals(a.getName(),"Operating system architecture");
                    junit.framework.Assert.assertEquals(a.getValue(),"64-bit");
                    break;
            }
        }

        productDetails.getAttributes();
    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetProduct(Call<ProductDetails> call, Throwable t) {

    }


    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetFeaturedProducts(ProductCollection productCollection) {
       List<Element> elementList = productCollection.getElements();
        for(Element e : elementList){
            List<Attribute> attributes = e.getAttributes();
            junit.framework.Assert.assertEquals(e.getTitle(),"testTitle");
            junit.framework.Assert.assertEquals(e.getDescription(),"testDescription");
            junit.framework.Assert.assertEquals(e.getUri(),"testUri");
            junit.framework.Assert.assertEquals(e.getType(),"testType");

            for(Attribute a : attributes){
                switch (a.getName()){
                    case "image":
                        junit.framework.Assert.assertEquals(a.getType(),"String");
                        junit.framework.Assert.assertEquals(a.getName(),"image");
                        junit.framework.Assert.assertEquals(a.getValue(),"/INTERSHOP/static/WFS/inSPIRED-inTRONICS-Site/-/inSPIRED/en_US/M/3934150-1725.jpg");
                        break;
                    case "salePrice":
                        SalePrice price = (SalePrice)  a.getValue();
                        SalePrice check = new SalePrice("Money",10,"USD");
                        junit.framework.Assert.assertEquals(a.getType(),"ResourceAttribute");
                        junit.framework.Assert.assertEquals(a.getName(),"salePrice");
                        junit.framework.Assert.assertEquals(price.getValue(), check.getValue());
                        junit.framework.Assert.assertEquals(price.getType(), check.getType());
                        junit.framework.Assert.assertEquals(price.getCurrencyMnemonic(), check.getCurrencyMnemonic());

                        break;
                    case "availability":
                        junit.framework.Assert.assertEquals(a.getType(),"Boolean");
                        junit.framework.Assert.assertEquals(a.getName(),"availability");
                        junit.framework.Assert.assertEquals(a.getValue(), true);
                        break;
                }
            }
        }

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetFeaturedProducts(Call<ProductCollection> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetProductsByImage(ProductCollection productCollection) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetProductsByImage(Call<ProductCollection> call, Throwable t) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onSuccessGetProductsByText(ProductCollection productCollection) {

    }

    @SuppressWarnings("unused")
    @Override
    public void onErrorGetProductsByText(Call<ProductCollection> call, Throwable t) {

    }
}
