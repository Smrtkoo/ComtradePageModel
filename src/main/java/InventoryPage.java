import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikelight;

    @FindBy(className = "shopping_cart_link")
    WebElement cartlink;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeTShirt;
    @FindBy(className = "product_sort_container")
    WebElement sortProducts;
    @FindBy(className = "inventory_item_price")
    WebElement highPrice;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickBackpack()
    {
        backpack.click();
    }
    public void clickBikeLight()
    {
        bikelight.click();
    }
    public void clickTShirt()
    {
        tshirt.click();
    }
    public String getCartNumber()
    {
        return cartlink.getText();
    }
    public void removeTShirt()
    {
        removeTShirt.click();
    }
    public void sortProducts(String text)
    {
        Select select = new Select(sortProducts);
        select.selectByVisibleText(text);
    }
    public String getPrice()
    {
        return highPrice.getText();
    }
    public void clickCart()
    {
        cartlink.click();
    }

}
