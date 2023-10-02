package tek.capstone.framework.utilities;

public class DataGeneratore2 {

	// Data generator
	 public static String emailGenerator() {
	    	String prefix = "student20";
	    	String suffix = "@tekschool.us";
	    	int random = (int)(Math.random()*10000);
	    	String email = prefix + random + suffix;
	    	return email;
	    }
	 public static String getPhoneNumber() {
			String phoneNumber ="2";
			for(int i = 0; i <9; i++) {
				phoneNumber += (int)(Math.random()*10);
			}
			return phoneNumber;
		}
	 public static String getCardNumber() {
		 String cardNumber = "";
		 for(int i = 0; i <16; i++) {
			 cardNumber += (int)(Math.random()*10);
			}
		 return cardNumber;
	 }
	 public static String getZipCode() {
		 String zipcode ="";
		 for (int i =1; i<=5; i++) {
			 zipcode += (int)(Math.random()*10);
		 }
		 return zipcode;
	 }
	 
	
}

