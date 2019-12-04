package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
    WebDriver driver;
    By userName = By.name("uid");
    By password = By.name("password");
    By signIn = By.name("btnLogin");    
    
    public PageLogin(WebDriver driver){

        this.driver = driver;

    }
    
    //Set user name in textbox
    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }

    //Set password in password textbox
    public void setPassword(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button
    public void clickLogin(){

            driver.findElement(signIn).click();

    } 
    
    // fill login
    public void loginApplication(String userName, String password){

        //Fill user name
        this.setUserName(userName);

        //Fill password
        this.setPassword(password);

        //Click Login button
        this.clickLogin();          
    }
   
}
