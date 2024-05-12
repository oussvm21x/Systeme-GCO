package BaseClasses.src;
import java.util.HashMap;


public class Clinique {
	 public static HashMap<String, Ortophoniste> ortophonistesMap = new HashMap<>();
	public static Ortophoniste ortophonisteCourrant  ;
	
	
	public static void createAccount(String firstName, String lastName, String address, String phoneNumber, String emailAddress, String password)
	{ 
		Ortophoniste e = new Ortophoniste(firstName,lastName,address,phoneNumber, emailAddress, password);
		 ortophonistesMap.put(emailAddress, e);
		 ortophonisteCourrant = e ;
		 
	}
	public void deleteAccount(String mail) {
	}
	
}
