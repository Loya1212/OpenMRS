package patient_registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Testclass {
	
	WebDriver driver;
	
@BeforeClass
	public void choosebrowser(String browser) {
	
	if (browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "G:\\selenium all jars\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "G:\\selenium all jars\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver","G:\\selenium all jars\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	else{System.out.println("Wrong browser selected try using Chrome, FireFox or Microsoft Edge");
	}
	driver.get("https://demo.openmrs.org/openmrs/login.htm");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@Test
	public void Loginpage_test() {
		LoginPageclass LPC= new LoginPageclass(driver);
		LPC.login_id();
		LPC.login_password();
		LPC.Inpatient_ward();
		LPC.Login_button();

	}
     
    public void patient_Registration() {
    	LoginPageclass LPC= new LoginPageclass(driver);
    	
    	LPC.Register_a_Patient();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	LPC.firstname();
    	LPC.middlename();
    	LPC.lastname();
    	LPC.nextbutton();
    	LPC.genderselection("Male");
    	LPC.nextbutton();
    	LPC.birthday();
        LPC.birthmonth();
        LPC.birthyear();
        LPC.nextbutton();
        LPC.address();
        LPC.nextbutton();
        LPC.phonenumber();
        LPC.nextbutton();
        LPC.nextbutton();
        LPC.confirmbutton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void DeleteRegisteredPatient() throws InterruptedException {
    	LoginPageclass LPC= new LoginPageclass(driver);
    	LPC.delete_patient();
    	LPC.delete_reason();
    	Thread.sleep(1000);
    	LPC.confirmright_button();
    	System.out.println("Registered Patient Deleted" );
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    }
    
    public void FindPatient_page() {
    	String url=driver.getCurrentUrl();
    	System.out.println(url);
  
    	if(url=="https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient") {
    		System.out.println("We are on find patient page");
    	}
    	else {driver.navigate().to("https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient");
    	System.out.println("We navigated to find patient page");}
    }
    public void FindandView_patient() throws InterruptedException {
    	LoginPageclass LPC= new LoginPageclass(driver);
    	LPC.find_patient();
    	LPC.view_Patient();
    }
    public void book_Appointment() throws InterruptedException {
    	LoginPageclass LPC= new LoginPageclass(driver);
    	LPC.Book_Appointment();
    	LPC.StartVisit();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	//LPC.Add_Attachment();
    	LPC.EndVisit();
    	WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable (By.className("s-buy")));
		LPC.confirm_end();
    	LPC.logout();
    }
    public void teardown() {
    driver.close();
    }
}
	
	


