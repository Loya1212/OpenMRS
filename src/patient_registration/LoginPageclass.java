package patient_registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginPageclass {
	//declaration(object repository)
	
    //For Login
		@FindBy(xpath="//input[@id=\"username\"]") private WebElement login_id;
		@FindBy(xpath="//input[@id=\"password\"]") private WebElement login_password;
		@FindBy(xpath="//li[@id=\"Inpatient Ward\"]") private WebElement Inpatient_ward;
		@FindBy(xpath="//input[@id=\"loginButton\"]") private WebElement Login_button;
		
	//For patient Registration	
		@FindBy(xpath="//a[@href=\"/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient\"]")private WebElement Register_a_patient;
		@FindBy(xpath="//input[@name=\"givenName\"]")private WebElement firstname;
		@FindBy(xpath="//input[@name=\"middleName\"]")private WebElement middlename;
		@FindBy(xpath="//input[@name=\"familyName\"]")private WebElement lastname;
		@FindBy(xpath="//button[@id=\"next-button\"]")private WebElement nextbutton;
		@FindBy(xpath="//option[@value=\"M\"]")private WebElement gender_male;
		@FindBy(xpath="//option[@value=\"F\"]")private WebElement gender_female;
		@FindBy(xpath="//input[@id=\"birthdateDay-field\"]")private WebElement birthday;
		@FindBy(xpath="//select[@id=\"birthdateMonth-field\"]") private WebElement birthmonth;
		@FindBy(xpath="//input[@id=\"birthdateYear-field\"]") private WebElement birthyear;
		@FindBy(xpath="//input[@id=\"address1\"]")private WebElement address;
		@FindBy(xpath="//input[@name=\"phoneNumber\"]") private WebElement phonenumber;
		@FindBy(xpath="//input[@id=\"submit\"]") private WebElement confirmbutton;
		
	//to Delete Registered Patient
		@FindBy(xpath="(//div[@class='col-1 col-lg-2'])[8]")private WebElement delete_patient;
		@FindBy(xpath="//input[@id=\"delete-reason\"]")private WebElement delete_reason;
		@FindBy(xpath="(//button[@class=\"confirm right\"])[6]")private WebElement confirmright_button;
		
	//To Find a Patient Record
		@FindBy(xpath="//input[@id=\"patient-search\"]")private WebElement SearchBox;
		@FindBy(xpath="//td[2]")private WebElement Search_Result;
		
		
	//View the Patient
		@FindBy(xpath="//div[@class=\"info-body\"][1]")private WebElement Diagnoses;
		@FindBy(xpath="//div[@class=\"gender-age col-auto\"]")private WebElement Gender_age;
		@FindBy(xpath="//span[@id=\"edit-patient-demographics\"]")private WebElement edit_button;
		@FindBy(xpath="//div[@id=\"coreapps-mostRecentVitals\"]")private WebElement All_Vitals;
		@FindBy(xpath="(//div[@class=\"info-header\"])[8]")private WebElement Recent_visit;
		
	//Book an Appointment	
		@FindBy(xpath="(//div[@class=\"col-11 col-lg-10\"])[5]")private WebElement Request_Appointment;
		@FindBy(xpath="//input[@id=\"appointment-type\"]")private WebElement Typeof_Appointment;
		@FindBy(xpath="(//a[@class=\"ng-scope ng-binding\"])[1]")private WebElement General_Medicine;
		@FindBy(xpath="//input[@id=\"save-button\"]")private WebElement Save_button;
		
	//	start Visit and add attachment
		@FindBy(xpath="(//div[@class=\"col-11 col-lg-10\"])[1]")private WebElement Start_Visit;
		@FindBy(xpath="//button[@id=\"start-visit-with-visittype-confirm\"]")private WebElement Confirmation;
		//@FindBy(xpath="//a[@class=\"button task activelist\"][5]")private WebElement Attachment;
		@FindBy(xpath="//form[@dropzone-directive=\"dropzoneConfig\"]")private WebElement dropzone;
		@FindBy(xpath="//a[@class=\"button left\"]")private WebElement cameraButton;
		@FindBy(xpath="//a[@class=\"button confirm\"]")private WebElement photo;
		@FindBy(xpath="//a[@class=\"button confirm\"]")private WebElement photo_confirm;
		@FindBy(xpath="//textarea[@ng-model=\"typedText.fileCaption\"]")private WebElement TextArea;
		@FindBy(xpath="//button[@ng-click=\"uploadFile()\"]")private WebElement Upload_button;
		
	//End Visit and Logout	
		@FindBy(xpath="(//a[@class=\"button task activelist\"])[1]")private WebElement End_Visit;
		@FindBy(xpath="(//button[@class=\"confirm right\"])[21]") WebElement confirm_end;
		@FindBy(xpath="//li[@class=\"nav-item logout\"]")private WebElement logout;
		
		 
		//Initialization
		
		
		public LoginPageclass(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public LoginPageclass() {

		}

//Usage
		//login methods
@Test
		public void login_id() {
			//login_id.click();
			login_id.sendKeys("Admin");
		}
			
		public void login_password() {
			//login_password.click();
			login_password.sendKeys("Admin123");
		}
		
		public void Inpatient_ward() {
			Inpatient_ward.click();
		}
		
		public void Login_button() {
			Login_button.click();
		}
		
		
		//Patient Registration and delete methods
		
		public void Register_a_Patient() {
			Register_a_patient.click();
			
		}
		public void firstname() {
			//firstname.click();
			firstname.sendKeys("Ravindra");
		}
		public void middlename() {
			//middlename.click();
			middlename.sendKeys("Dilip");
		}
		public void lastname() {
			//lastname.click();
			lastname.sendKeys("Khadse");
		}
		public void nextbutton() {
			nextbutton.click();
		}
		public void genderselection( String gender) {
			if(gender.equalsIgnoreCase("male")) {
				gender_male.click();
			}else if(gender.equalsIgnoreCase("female")) {
				gender_female.click();}
		}
		public void birthday() {
			birthday.sendKeys("14");
		}
		public void birthmonth() {
			Select month =new Select(birthmonth);
			Assert.assertFalse(birthmonth.isSelected());
			month.selectByVisibleText("June");
			Assert.assertEquals(month.getFirstSelectedOption().getText(), "June");
			Reporter.log("birthmonth selected",true);
		}
		public void birthyear() {
			birthyear.sendKeys("1993");
		}
		public void address() {
			address.sendKeys("Pune");
		}
		public void phonenumber() {
			phonenumber.sendKeys("9284778158");
		}
		public void confirmbutton() {
			confirmbutton.click();
		}
		public void delete_patient() {
			delete_patient.click();
		}
		public void delete_reason() {
			delete_reason.sendKeys("Cured");
		}
		public void confirmright_button() {
			confirmright_button.click();
		}
		
		
		
		//Find Patient record methods
		public void find_patient() throws InterruptedException {
			SearchBox.sendKeys("Alex Mandel Jorden");
			Thread.sleep(2000);
			Search_Result.click();
		}
		
		public void view_Patient() {
			Assert.assertEquals(true, Gender_age.isDisplayed());
			Reporter.log("Gender and Age of Patient is Displayed",true);
			
			Assert.assertEquals(true,edit_button.isDisplayed());
			Assert.assertEquals(true,edit_button.isEnabled());
			Reporter.log("'Edit button' to edit Patient's Demographic information is Displayed and is unabled",true);
			
			Assert.assertEquals(true, Diagnoses.isDisplayed());
			Reporter.log("Patient's Diagnoses Result is Displayed",true);
			
			Assert.assertEquals(true, All_Vitals.isDisplayed());
			Reporter.log("Most Recent Vitals of the Patient are Displayed",true);
			
			Assert.assertEquals(true, Recent_visit.isDisplayed());
			Reporter.log("Recent Visit date of the patient is Displayed");
		}
		
		public void Book_Appointment() throws InterruptedException {
			Request_Appointment.click();
			Thread.sleep(1000);
			Typeof_Appointment.sendKeys("General Medicine");
			General_Medicine.click();
			//Select Appointment_type =new Select(Typeof_Appointment);
			//Typeof_Appointment.selectByVisibleText("General Medicine")
			System.out.println("General Medicine selected");
			Save_button.click();
			System.out.println("save button clicked");
			
		}
		
		public void StartVisit() {
			Start_Visit.click();
			Confirmation.click();
		}
//		public void Add_Attachment() throws InterruptedException {
//			Attachment.click();
//			//dropzone.click();
//			cameraButton.click();
//			Thread.sleep(50000);
//		    System.out.println("Please allow camera permision to add attachment");
//			photo.click();
//			photo_confirm.click();
//			TextArea.sendKeys("this is the only attachment we can do with selenium");
//			Upload_button.click();
//		}
		public void EndVisit() throws InterruptedException {
			End_Visit.click();}
		public void confirm_end() {
			confirm_end.click();	
		}
		
		public void logout() {
			logout.click();
		}
			
		}
		
		


