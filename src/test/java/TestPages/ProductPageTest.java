package TestPages;

import Pages.ProductPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductPageTest extends BaseTest {

    ProductPage obj;

    @Test
    public void verifyAllProductsAndProductDetailsPage(){

        obj = new ProductPage(driver);

        obj.HomeCheck();
        obj.productsButtonFun();
        obj.verifyProductsButtonFun();

        obj.verifyProductsVisableFun();
        obj.clickOnViewProductFun();

        obj.checkNavigationIntoRightProductFun();
        obj.checkDetailsOfFirstProduct();
    }

    @Test
    public void searchProduct(){

        obj = new ProductPage(driver);

        obj.HomeCheck();
        obj.productsButtonFun();
        obj.verifyProductsButtonFun();

        obj.verifyProductsVisableFun();

        obj.addValueToSearchBar(utils.TestConfig.productSearch());
        obj.clickOnSearchButton();

        obj.verifySearchedProductFun();
        obj.getRelatedSearchProductsFun();
    }
}
