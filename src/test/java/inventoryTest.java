import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class inventoryTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;


    @BeforeMethod
    public void setUp()
    {
        driver = browserOpen();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        loginPage.LogInOnPage();
    }
    @Test
    public void addToCart()
    {
        //Act
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");

        //Arange
        loginPage.clickLogin();*/
        inventoryPage.clickBackpack();
        inventoryPage.clickBikeLight();
        inventoryPage.clickTShirt();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");
    }
    @Test
    public void removeTShirt()
    {
        //Act
       /* loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");

        //Arange
        loginPage.clickLogin();*/
        inventoryPage.clickTShirt();
        inventoryPage.clickBackpack();
        inventoryPage.clickBikeLight();
        inventoryPage.removeTShirt();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(),"2");
    }
    @Test
    public void sortHighProduct()
    {
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();*/

        inventoryPage.sortProducts("Price (high to low)");

        Assert.assertEquals(inventoryPage.getPrice(),"$49.99");
    }
    @Test
    public void sortLowProduct()
    {
        /*loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();*/

        inventoryPage.sortProducts("Price (low to high)");

        Assert.assertEquals(inventoryPage.getPrice(),"$7.99");
    }
    @Test
    public void buyProductsToTheEnd()
    {
        inventoryPage.clickBikeLight();
        inventoryPage.clickBackpack();
        inventoryPage.clickTShirt();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.setForm("Bojan","Lončarević","11070");
        checkoutStepOnePage.clickFinish();

        Assert.assertEquals(checkoutStepOnePage.complete(),"Thank you for your order!");

    }

    @Test
    public void buyProductsWithoutData()
    {
        inventoryPage.clickBikeLight();
        inventoryPage.clickBackpack();
        inventoryPage.clickTShirt();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.setForm("","","");

        Assert.assertEquals(checkoutStepOnePage.getError(),"Error: First Name is required");
    }
    @Test
    public void removeProductfromCart ()
    {
        inventoryPage.clickTShirt();
        inventoryPage.clickBackpack();
        inventoryPage.clickBikeLight();
        inventoryPage.clickCart();
        inventoryPage.removeTShirt();

        Assert.assertEquals(inventoryPage.getCartNumber(),"2");

    }
    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}
