
package PageObjects;

import models.Customer;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageResgisteredComplete {
    private static final int DELAY = 10;
    
    WebDriver driver;
    private By name;
    private By gender;
    private By dateOfBirthDate;
    private By address;
    private By city;
    private By state;
    private By pin;
    private By mobileNumber;
    private By email;
    public By btncontinue;

    public pageResgisteredComplete(WebDriver driver) {
        this.driver = driver;
        this.name = By.xpath("//*[@id=\"customer\"]/tbody/tr[5]/td[2]");
        this.gender = By.xpath("//*[@id=\"customer\"]/tbody/tr[6]/td[2]");
        this.dateOfBirthDate = By.xpath("//*[@id=\"customer\"]/tbody/tr[7]/td[2]");
        this.address = By.xpath("//*[@id=\"customer\"]/tbody/tr[8]/td[2]");
        this.city = By.xpath("//*[@id=\"customer\"]/tbody/tr[9]/td[2]");
        this.state = By.xpath("//*[@id=\"customer\"]/tbody/tr[10]/td[2]");
        this.pin = By.xpath("//*[@id=\"customer\"]/tbody/tr[11]/td[2]");
        this.mobileNumber = By.xpath("//*[@id=\"customer\"]/tbody/tr[12]/td[2]");
        this.email = By.xpath("//*[@id=\"customer\"]/tbody/tr[13]/td[2]");
        this.btncontinue = By.xpath("//*[@id=\"customer\"]/tbody/tr[14]/td/a");
    }
    
    public void clickBtnContinue()
    {
        driver.findElement(btncontinue).click();
    }
    
    public boolean verifyData(Customer customer)
    {
        boolean isAllRight = false;
        Customer customerToVerify = new Customer();
        
        //name
        WebElement weName = waitWebElement(getDriver(), getName(), DELAY);
        customerToVerify.setName(weName.getText());
        System.out.println("name:" + weName.getText());
        
        //gender
        WebElement weGender= waitWebElement(getDriver(), getGender(), DELAY);
        if (weGender.getText().equalsIgnoreCase("female")) {
            //customerToVerify.setGender("f");
        }
        else if(weGender.getText().equalsIgnoreCase("male"))
        {
            customerToVerify.setGender("m");
        }
        System.out.println("gender:" + weGender.getText());
        
        //birthday
        WebElement weBirthDay= waitWebElement(getDriver(), getDateOfBirthDate(), DELAY);
        customerToVerify.setDateOfBirth(weBirthDay.getText());
        System.out.println("bithday:" + weBirthDay.getText());
        
        //address
        WebElement weAddress = waitWebElement(getDriver(), getAddress(), DELAY);
        customerToVerify.setAddress(weAddress.getText());
        System.out.println("address:" + weAddress.getText());
        
        //city
        WebElement weCity = waitWebElement(getDriver(), getCity(), DELAY);
        customerToVerify.setCity(weCity.getText());
        System.out.println("city:" + weCity.getText());
        
        //state
        WebElement weState = waitWebElement(getDriver(), getState(), DELAY);
        customerToVerify.setState(weState.getText());
        System.out.println("state:" + weState.getText());
        
        //pin
        WebElement wePin = waitWebElement(getDriver(), getPin(), DELAY);
        customerToVerify.setPin(wePin.getText());
        System.out.println("pin:" + wePin.getText());
        
        //mobile phone
        WebElement weMobilePhone = waitWebElement(getDriver(), getMobileNumber(), DELAY);
        customerToVerify.setMobileNumber(weMobilePhone.getText());
        System.out.println("city:" + weMobilePhone.getText());
        
        //email
        WebElement weEmail = waitWebElement(getDriver(), getEmail(), DELAY);
        customerToVerify.setEmail(weEmail.getText());
        System.out.println("city:" + weEmail.getText());
        
        if (customer.getName().equalsIgnoreCase(customerToVerify.getName())) {
            if (customer.getGender().equalsIgnoreCase(customerToVerify.getGender())) {
                if (customer.getDateOfBirth().equalsIgnoreCase(customerToVerify.getDateOfBirth())) {
                    if (customer.getAddress().equalsIgnoreCase(customerToVerify.getAddress())) {
                        if (customer.getCity().equalsIgnoreCase(customerToVerify.getCity())) {
                            if (customer.getState().equalsIgnoreCase(customerToVerify.getState())) {
                                if (customer.getPin().equalsIgnoreCase(customerToVerify.getPin())) {
                                    if (customer.getMobileNumber().equalsIgnoreCase(customerToVerify.getMobileNumber())) {
                                        if (customer.getEmail().equalsIgnoreCase(customerToVerify.getEmail())) {
                                            isAllRight = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return isAllRight;
    }
    
    public WebElement waitWebElement(WebDriver webdriver, By locator, int duracion) {
     //tiempo de espera del elemento
     //Duration timeout = Duration.ofSeconds(duracion);
     //Explicit Wait is code you define to wait for a certain condition to occur before proceeding further in the code.
     WebDriverWait wait = new WebDriverWait(webdriver, duracion);
     //Selenium encapsulates every form element as an object of WebElement.
     WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

     return element;
    }
       
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getName() {
        return name;
    }

    public void setName(By name) {
        this.name = name;
    }

    public By getGender() {
        return gender;
    }

    public void setGender(By gender) {
        this.gender = gender;
    }

    public By getDateOfBirthDate() {
        return dateOfBirthDate;
    }

    public void setDateOfBirthDate(By dateOfBirthDate) {
        this.dateOfBirthDate = dateOfBirthDate;
    }

    public By getAddress() {
        return address;
    }

    public void setAddress(By address) {
        this.address = address;
    }

    public By getCity() {
        return city;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public By getState() {
        return state;
    }

    public void setState(By state) {
        this.state = state;
    }

    public By getPin() {
        return pin;
    }

    public void setPin(By pin) {
        this.pin = pin;
    }

    public By getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(By mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public By getEmail() {
        return email;
    }

    public void setEmail(By email) {
        this.email = email;
    }

}
