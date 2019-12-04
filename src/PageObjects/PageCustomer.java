package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCustomer {
    private static final int DELAY = 10;
    
    WebDriver driver;
    private By nameField;
    private By genderRadioButton;
    private By dateOfBirthDate;
    private By addressField;
    private By cityField;
    private By stateField;
    private By pinField;
    private By mobileNumberField;
    private By emailField;
    private By passwordField;

    public PageCustomer(WebDriver driver) {
        this.driver = driver;
        this.nameField = By.name("name");
        this.dateOfBirthDate = By.xpath("//*[@id=\"dob\"]");
        this.addressField = By.name("addr");
        this.cityField = By.name("city");
        this.stateField = By.name("state");
        this.pinField = By.name("pinno");
        this.mobileNumberField = By.name("telephoneno");
        this.emailField = By.name("emailid");
        this.passwordField = By.name("password");
    }
    
    
    public void selectName(String name) {
        WebElement weName = waitWebElement(getDriver(), getNameField(), DELAY);
        weName.sendKeys(name);
    }

    public void selectGender(String gender) {
        int option = 1;

        if (gender.equalsIgnoreCase("f")) {
            option = 2;
        } else {
            System.out.println("debe elegir ya sea : 'f' o 'm'");
        }
        
        By xpathGender = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[" + option + "]");
        setGenderRadioButton(xpathGender); 
        WebElement weRadioButton = waitWebElement(getDriver(), getGenderRadioButton(), DELAY);
        weRadioButton.click();
    }

    public void selectDateOfBirthDate(String dateOfbirth) throws InterruptedException{
        //Find the date time picker control
        WebElement weDate = waitWebElement(getDriver(), getDateOfBirthDate(), DELAY);;
        
        String año = dateOfbirth.substring(0,4);
        String mes = dateOfbirth.substring(5,7);
        String dia = dateOfbirth.substring(8,10);

        weDate.click();
        //ajustamos del todo a la izquieda para que comience por el año
        weDate.sendKeys(Keys.ARROW_RIGHT);
        weDate.sendKeys(Keys.ARROW_RIGHT);
        //año
        weDate.sendKeys(año);
        weDate.sendKeys(Keys.ARROW_LEFT);
        //mes
        weDate.sendKeys(mes);
        weDate.sendKeys(Keys.ARROW_LEFT);
        weDate.sendKeys(Keys.ARROW_LEFT);
        //dia
        weDate.sendKeys(dia);
    }

    public void selectAddress(String address) {
        WebElement weAddress = waitWebElement(getDriver(), getAddressField(), DELAY);
        weAddress.sendKeys(address);
    }

    public void selectCity(String city) {
        WebElement weCity = waitWebElement(getDriver(), getCityField(), DELAY);
        weCity.sendKeys(city);
    }

    public void selectState(String state) {
        WebElement weState = waitWebElement(getDriver(), getStateField(), DELAY);
        weState.sendKeys(state);
    }

    public void selectPin(String pin) {
        WebElement wePin = waitWebElement(getDriver(), getPinField(), DELAY);
        wePin.sendKeys(pin);
    }

    public void selectMobileNumber(String mobileNumber) {
        WebElement weMobileNumber = waitWebElement(getDriver(), getMobileNumberField(), DELAY);
        weMobileNumber.sendKeys(mobileNumber);
    }

    public void selectEmail(String email) {
        WebElement weEmail = waitWebElement(getDriver(), getEmailField(), DELAY);
        weEmail.sendKeys(email);
    }

    public void selectPassword(String password) {
        WebElement wePassword = waitWebElement(getDriver(), getPasswordField(), DELAY);
        wePassword.sendKeys(password);
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
    
    //Click on submit button
    public void clickSubmit(){
        By submit = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]");
        WebElement weSubmit = waitWebElement(getDriver(), submit, DELAY);
        weSubmit.click();
    } 
    
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getNameField() {
        return nameField;
    }

    public void setNameField(By nameField) {
        this.nameField = nameField;
    }

    public By getGenderRadioButton() {
        return genderRadioButton;
    }

    public void setGenderRadioButton(By genderRadioButton) {
        this.genderRadioButton = genderRadioButton;
    }

    public By getDateOfBirthDate() {
        return dateOfBirthDate;
    }

    public void setDateOfBirthDate(By dateOfBirthDate) {
        this.dateOfBirthDate = dateOfBirthDate;
    }

    public By getAddressField() {
        return addressField;
    }

    public void setAddressField(By addressField) {
        this.addressField = addressField;
    }

    public By getCityField() {
        return cityField;
    }

    public void setCityField(By cityField) {
        this.cityField = cityField;
    }

    public By getStateField() {
        return stateField;
    }

    public void setStateField(By stateField) {
        this.stateField = stateField;
    }

    public By getPinField() {
        return pinField;
    }

    public void setPinField(By pinField) {
        this.pinField = pinField;
    }

    public By getMobileNumberField() {
        return mobileNumberField;
    }

    public void setMobileNumberField(By mobileNumberField) {
        this.mobileNumberField = mobileNumberField;
    }

    public By getEmailField() {
        return emailField;
    }

    public void setEmailField(By emailField) {
        this.emailField = emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(By passwordField) {
        this.passwordField = passwordField;
    }
    
}
