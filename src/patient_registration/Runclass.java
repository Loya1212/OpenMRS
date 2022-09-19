package patient_registration;

import org.testng.annotations.Test;

public class Runclass{
	

     @Test
       public void setup() throws InterruptedException {
       Testclass t=new Testclass();
       t.choosebrowser("chrome");
       t.Loginpage_test();
       t.patient_Registration();
       t.DeleteRegisteredPatient();
       t.FindPatient_page();
       t.FindandView_patient();
       t.book_Appointment();
       t.teardown();
}


	





	
	
	
}

