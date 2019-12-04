package seleniumpractice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.PageLogin;
import PageObjects.PageCustomer;
import PageObjects.PageDelete;
import PageObjects.pageResgisteredComplete;
import java.math.BigInteger;
import java.util.Random;
import models.Customer;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SeleniumPracticeTest {
    private static final int DELAY = 10;
    private static WebDriver driver = null;
    
    PageLogin log;
    PageCustomer PageCustomer;
    pageResgisteredComplete pageResgisteredComplete;
    Customer customer;
    
    public SeleniumPracticeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {                
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");             
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       driver = new ChromeDriver();   
       driver.manage().window().maximize();
       driver.get("http://demo.guru99.com/V4/index.php");
       driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS); 
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * validar el ingreso al sistema
     */
    @Test
    public void loginValidator() {
        this.login();
        
        //verificar el ingreso al sistema
        By xpathWelcome = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
        Assert.assertTrue(driver.findElement(xpathWelcome).getText().contains("Manger Id : mngr234059"));
    }
    
    /** 
     * Verifica que el campo “Customer Name” es obligatorio
     * @throws java.lang.InterruptedException
     */
    @Test
    public void mandatoryCustomerName() throws InterruptedException{ 
        this.login();
        
        /*Precondition*/
        // presionar click en el boton "New Customer"
        By xpathNewCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
        driver.findElement(xpathNewCustomer).click();
        
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS); 
        PageCustomer = new PageCustomer(driver);
        
        //Datos del cliente
        customer = this.generateCustomer();
        
        PageCustomer.selectName("");
        PageCustomer.selectGender(customer.getGender());
        PageCustomer.selectDateOfBirthDate(customer.getDateOfBirth());
        PageCustomer.selectAddress(customer.getAddress());
        PageCustomer.selectCity(customer.getCity());
        PageCustomer.selectState(customer.getState());
        PageCustomer.selectPin(customer.getPin());
        PageCustomer.selectMobileNumber(customer.getMobileNumber());
        PageCustomer.selectEmail(customer.getEmail());
        PageCustomer.selectPassword(customer.getPass());
       
        Thread.sleep(2000);
        PageCustomer.clickSubmit();
        
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        
        //validar que el campo customer name sea obligatorio
        By xpathCustomerName = By.xpath("//*[@id=\"message\"]");
        Assert.assertTrue(driver.findElement(xpathCustomerName).getText().contains("Customer name must not be blank"));
    }
    
    /**
     * Valida el ingreso de un cliente
     * 
     * @throws InterruptedException 
     */
    @Test
    public void createCustomer() throws InterruptedException{ 
        this.login();
        
        /*Precondition*/
        // presionar click en el boton "New Customer"
        By xpathNewCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
        driver.findElement(xpathNewCustomer).click();
        
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS); 
        PageCustomer = new PageCustomer(driver);
        
        //Datos del cliente
        customer = this.generateCustomer();
        
        PageCustomer.selectName(customer.getName());
        PageCustomer.selectGender(customer.getGender());
        PageCustomer.selectDateOfBirthDate(customer.getDateOfBirth());
        PageCustomer.selectAddress(customer.getAddress());
        PageCustomer.selectCity(customer.getCity());
        PageCustomer.selectState(customer.getState());
        PageCustomer.selectPin(customer.getPin());
        PageCustomer.selectMobileNumber(customer.getMobileNumber());
        PageCustomer.selectEmail(customer.getEmail());
        PageCustomer.selectPassword(customer.getPass());
       
        Thread.sleep(2000);
        PageCustomer.clickSubmit();
        Thread.sleep(3000);
        
        
        try
        {
            //verificar que el registro se creo correctamente
            By xpathSuccess = By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p");
            Assert.assertTrue(driver.findElement(xpathSuccess).getText().contains("Customer Registered Successfully!!!"));
        
        
            //mostrar el id del cliente y guardarlo en la clase customer
            By xpathIDCustomer = By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");
            customer.setCustomerIdCode(driver.findElement(xpathIDCustomer).getText());
            System.out.println("ID CUSTOMER:" + customer.getCustomerIdCode());

            pageResgisteredComplete = new pageResgisteredComplete(driver);
            boolean isDataOK = pageResgisteredComplete.verifyData(customer);
            Assert.assertTrue(isDataOK);
            pageResgisteredComplete.clickBtnContinue();
        }
        catch(Exception e)
        {
            if (driver.switchTo().alert().getText().contains("Customer could not be added !!")) {
                System.out.println("Una extraña anomalia de la pagina, correr el test nuevamente");
            }
            System.out.println("error details :" + e);
        }
    }
    
    /**
     * Valida la eliminacion de un cliente en el sistema
     * 
     * @throws InterruptedException 
     */
    @Test
    public void deleteCustomerTest() throws InterruptedException{ 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
        /*Precondition*/
        createCustomer();
        // presionar click en el boton "delete Customer"
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By xpathDeleteCustomer = By.xpath("/html/body/div[3]/div/ul/li[4]/a");
        driver.findElement(xpathDeleteCustomer).click();
         
        
        //borrar al usuario 
        PageDelete pageDelete = new PageDelete(driver);
        pageDelete.deleteCustomerById(customer.getCustomerIdCode());
        
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        
        //validar que el cliente se haya eliminado
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer deleted Successfully"));
        
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        
        //verificar que se halla borrado el customer
        By xpathEdit = By.xpath("/html/body/div[3]/div/ul/li[3]/a");
        driver.findElement(xpathEdit).click();
        
        By customerId = By.name("cusid");
        driver.findElement(customerId).sendKeys(customer.getCustomerIdCode());
        
        By submit = By.name("AccSubmit");
        driver.findElement(submit).click();
        
        Thread.sleep(1000);
        //validar que el cliente en realidad no existe
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer does not exist!!"));
        
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    
    /**
     * Loguearse en el sistema
     */
    private void login()
    {
        String userId = "mngr234059";
        String password = "Aqesady";
        log = new PageLogin(driver);
        log.loginApplication(userId, password);
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS); 
    }
    
    private Customer generateCustomer()
    {
         //Datos del cliente
        String name = "benjamin"; 
        
        String gender = "m";
        int RandomGender = (int) (Math.random() * 1) + 2;
        if (RandomGender == 1) {
            gender = "f";
        }
       
        StringBuilder sbDate = new StringBuilder();
        //año
        sbDate.append(Integer.toString((int) (Math.random() * (2019-1930)) + 1930));
        sbDate.append("-");
        //mes
        sbDate.append(Integer.toString((int) (Math.random() * (12-10)) + 10));
        sbDate.append("-");
        //dia
        sbDate.append(Integer.toString((int) (Math.random() * (30-10)) + 10));
        String dateOfBirth = sbDate.toString();
        
        StringBuilder sbaddress = new StringBuilder();
        sbaddress.append("cra ");
        sbaddress.append(Integer.toString((int) (Math.random() * 300) + 1));
        sbaddress.append("a ");
        sbaddress.append(Integer.toString((int) (Math.random() * (9999-1000)) + 1000));
        sbaddress.append(" sector ");
        sbaddress.append(Integer.toString((int) (Math.random() * 100) + 1));
        String address = sbaddress.toString();
        
        String city = "medellin";
        String state = "Antioquia";
        String pin = Integer.toString((int) (Math.random() * (999999-100000)) + 100000);
        
        StringBuilder sbMobileNumber = new StringBuilder();
        sbMobileNumber.append("31");
        sbMobileNumber.append(Integer.toString((int) (Math.random() * (90000000-10000000)) + 10000000));
        String mobileNumber = sbMobileNumber.toString();
        
        //crear un correo diferente
        StringBuilder sbEmail = new StringBuilder();
        sbEmail.append("benjamin");
        sbEmail.append(Integer.toString((int) (Math.random() * 10000000) + 1));
        sbEmail.append("@gmail.com");
        String email = sbEmail.toString();
        
        StringBuilder sbPass = new StringBuilder();
        sbPass.append("nimajneb");
        sbPass.append(Integer.toString((int) (Math.random() * 1000000) + 1));
        String pass = sbPass.toString();
        
        //creamos el objeto customer
        customer = new Customer(name, gender, dateOfBirth, address, city, state, pin, mobileNumber, email, pass);
        
        return customer;
    }
}
