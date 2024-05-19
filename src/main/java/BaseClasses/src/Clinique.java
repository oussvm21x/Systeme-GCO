package BaseClasses.src;
import java.io.*;
import java.util.HashMap;


public class Clinique implements Serializable {
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

	public static void sauvegarderClinique(String fichier) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fichier))) {
			outputStream.writeObject(ortophonistesMap);
			outputStream.writeObject(ortophonisteCourrant);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void chargerClinique(String fichier) {

			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fichier))) {
			ortophonistesMap = (HashMap<String, Ortophoniste>) inputStream.readObject();
			ortophonisteCourrant = (Ortophoniste) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

    }
