package BaseClasses.src;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Patient.Adult;
import BaseClasses.Patient.Child;
import BaseClasses.Patient.Patient;
import Enums.EAppointment;
import Enums.EPatient;

import static Enums.EPatient.ADULT;

public class Ortophoniste implements Serializable {
    private String firstName ;
    private String lastName ;
    private String address ;
    private String phoneNumber ;
    private String emailAddress ;
    private String password ;
    private String discription ;
    private int nbClients =0;
    private int lenght =0;
    private int lenghtArchive =0;
    public  HashMap<Integer, Patient> PatientNAD = new HashMap<>();
    private Patient[] Patients = new Patient[100] ;
    private Patient[] Archive = new Patient[100]  ;
    private HashMap<LocalDate, Appointment[]> appointments ;



    public Ortophoniste(String firstName, String lastName, String address, String phoneNumber, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public Patient recherchePatient(int numDossier) {
        if(PatientNAD.containsKey(numDossier)){
            return  PatientNAD.get(numDossier) ;
        }
        return null ;
    }
    public void ajouterPatient(Patient e){
        e.setId(lenght);
        Patients[lenght]= e;
        lenght++;
        nbClients++;

    }

    public void Archiver(int i){
        Patient e =  Patients[i];
        if(PatientNAD.containsValue(e)){
            PatientNAD.remove(e.getDossier().getNumDossier());
        }
        e.setId(lenghtArchive);
        Archive[lenghtArchive]= e;
        lenghtArchive++;
        for (int j=i ; j < lenght-1 ; j++){
            Patients[j+1].setId(j);
            Patients[j]= Patients[j+1];

        }
        lenght--;
    }
    public void Recuperer(int i){
        Patient e =  Archive[i];
        e.setId( lenght);
        Patients[lenght]= e;
        lenght++;
        for (int j=i ; j < lenghtArchive-1 ; j++){
            Archive[j+1].setId(j);
            Archive[j]= Archive[j+1];
        }
        lenghtArchive--;
    }


    // Getters et setters pour password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public Patient[] getArchive() {
        return Archive;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNbClients() {
        return nbClients;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDiscription() {
        return discription;
    }

    public int getLenght() {
        return lenght;
    }

    public Patient getPatientSansDossier(int i ) {
        return Patients[i];
    }

    public int getLenghtArchive() {
        return lenghtArchive;
    }
    public Patient getPatientArchives(int i ) {
        return Archive[i];
    }

    public boolean addAppointment(LocalDate date, Appointment newAppointment) {
        if (appointments == null) {
            appointments = new HashMap<>();
        }
        if (appointments.containsKey(date)) {
            Appointment[] existingAppointments = appointments.get(date);
            for (Appointment appointment : existingAppointments) {
                LocalTime appointmentEndTime = appointment.getHour().plusHours(appointment.getDuration().getHour())
                        .plusMinutes(appointment.getDuration().getMinute());
                if (appointment.getHour().isBefore(newAppointment.getHour()) && appointmentEndTime.isAfter(newAppointment.getHour())) {
                    return false;
                }else {
                 appointmentEndTime = newAppointment.getHour().plusHours(newAppointment.getDuration().getHour())
                            .plusMinutes(newAppointment.getDuration().getMinute());
                    if (appointment.getHour().isAfter(newAppointment.getHour()) && appointmentEndTime.isAfter(newAppointment.getHour())) {
                        return false;
                    }else {
                        if (appointment.getHour().equals(newAppointment.getHour())) {
                            return false;
                        }
                    }
                }
            }
            Appointment[] updatedAppointments = Arrays.copyOf(existingAppointments, existingAppointments.length + 1);
            updatedAppointments[updatedAppointments.length - 1] = newAppointment;
            appointments.put(date, updatedAppointments);
        } else {
            appointments.put(date, new Appointment[]{ newAppointment });
        }
        return true;
    }

}
