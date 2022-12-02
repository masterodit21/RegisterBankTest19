package stepdefs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
    private WebDriver driver ;
    private String baseURL = "https://demo.guru99.com";

    @Given("User sedang berada di halaman register")
    public void user_sedang_berada_di_halaman_register() {
        System.setProperty("webdriver.edge.driver",
                "D:\\webdriver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @When("User memasukan email {string}")
    public void user_memasukan_email(String string) {
        WebElement id = driver.findElement(By.xpath("//input[@name='emailid']"));
        id.sendKeys(string);
    }
    @When("User menekan tombol submit")
    public void user_menekan_tombol_submit() {
        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
    }

    @Then("User akan melihat kredensial yang diberikan")
    public void user_akan_melihat_kredensial_yang_diberikan() {
        WebElement alert = driver.findElement(By.xpath("//h2[normalize-space()='Access details to demo site.']"));
        String expected = "Access details to demo site.";
        assertEquals(alert.getText(), expected);
        driver.quit();
    }

    @Then("User akan melihat pesan validasi {string}")
    public void user_akan_melihat_pesan_validasi(String string) {
        WebElement alert = driver.findElement(By.xpath("//label[@id='message9']"));
        String expected = "Email ID is not valid";
        assertEquals(alert.getText(),expected);
        driver.quit();
    }
}