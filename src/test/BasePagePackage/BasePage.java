package BasePagePackage;

import Pages.bookStorePages.BookStore;
import Pages.bookStorePages.Login;
import Pages.bookStorePages.Profile;
import Pages.elementsPages.*;
import Pages.formsPages.PracticeForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BasePage {

    public final static String PAGE_URL = "https://demoqa.com/";
    public WebDriverManager webDriverManager;
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public Actions actions;
    public JavascriptExecutor js;

    public IndexPage indexPage;
    public Elements elements;
    public TextBox textBox;
    public RadioButton radioButton;
    public Buttons buttons;
    public Links links;
    public DynamicProperties dynamicProperties;
    public UploadAndDownload uploadAndDownload;
    public CheckBox checkBox;
    public BrokenImagesLinks brokenImagesLinks;
    public PracticeForm practiceForm;

    public WebTables webTables;
    public Login login;
    public BookStore bookStore;
    public Profile profile;

    @BeforeClass
    public void setUp() {

        webDriverManager = new ChromeDriverManager();
        webDriverManager.setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

        //Elements, sub list
        indexPage = new IndexPage(driver);
        elements = new Elements(driver);
        textBox = new TextBox(driver);
        radioButton = new RadioButton(driver);
        buttons = new Buttons(driver);
        links = new Links(driver);
        dynamicProperties = new DynamicProperties(driver);
        checkBox = new CheckBox(driver);
        uploadAndDownload = new UploadAndDownload(driver);
        brokenImagesLinks = new BrokenImagesLinks(driver);
        webTables = new WebTables(driver);

        //Forms
        practiceForm = new PracticeForm(driver);

        //BookStore Application
        login = new Login(driver);
        bookStore = new BookStore(driver);
        profile = new Profile(driver);

        driver.manage().window().maximize();
        driver.navigate().to(PAGE_URL);
    }

    @AfterClass
    public void closeProgram(){
        //driver.close();
    }

}
