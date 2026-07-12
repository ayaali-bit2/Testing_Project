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
        obj.clickOnAddToCartFirstProduct();
        obj.clickOnAddToCart();
        obj.clickOnViewCart();

    }
}
