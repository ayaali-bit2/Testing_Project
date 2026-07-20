package TestPages;

import Pages.ProductQuantityInCart;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ProductQuantityInCartTest extends BaseTest {

    ProductQuantityInCart obj;

    @Test
    public void verifyProductQuantityInCart(){
        obj = new ProductQuantityInCart(driver);
        obj.HomeCheck();
        obj.clickOnViewProduct();
        obj.verifyProductDetailIsOpened();

        String quantity = "4";
        obj.clickOnAddToCartFirstProduct(quantity);
        obj.clickOnAddToCart();
        obj.clickOnViewCart();
        obj.verifyDetailsOfFirstProduct(quantity);
    }
}
