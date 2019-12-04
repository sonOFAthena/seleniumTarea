
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageDelete {
    
    WebDriver driver;
    private By customerIDField;

    public PageDelete(WebDriver driver) {
        this.driver = driver;
    }
    
    /*
    * borra el usuario dado un id
    * 
    * @param id    ID usuario
    */
    public void deleteCustomerById(String id){
        By cusid = By.name("cusid");
        setCustomerIDField(cusid);
        driver.findElement(getCustomerIDField()).sendKeys(id);
        By deleteButton = By.name("AccSubmit");
        driver.findElement(deleteButton).click();
    }
    
    
    public By getCustomerIDField() {
        return customerIDField;
    }

    public void setCustomerIDField(By customerIDField) {
        this.customerIDField = customerIDField;
    }
}
