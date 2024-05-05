package BaseClasses.src;


public class Ortophoniste {
    private String firstName ;
    private String lastName ;
    private String address ;
    private String phoneNumber ;
    private String emailAddress ;
    private String password ;

    //Constructeure
    public Ortophoniste(String firstName, String lastName, String address, String phoneNumber, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    // Getters et setters pour password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createAccount(){
        //Cette methode va juste prend les infos puis appeler le constructure
        //Logic collection des donnes
        //Appeler le constructeure
    }
    public void updateAccount(){
        //ca va permmetre de fair des modification sur les infos en utulisant les setters et les getters
    }

    public void deleteAccount(){
        //detroy object , idk how to do that in java but it's easy normalement
    }
    public void LogIn() {
        //Ignore it rn , when we implement the interface we'll implement it
    }
}
