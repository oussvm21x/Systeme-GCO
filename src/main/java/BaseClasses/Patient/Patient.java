package BaseClasses.Patient;

import BaseClasses.Appointments.Appointment;
import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;

public  class Patient implements Serializable {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
    protected String birthPlace;
    protected String address;
    protected EPatient type;
    protected Dossier dossier;
    protected  Boolean Urgent ;
    protected Integer id ;
    private HashMap<LocalDate, Appointment[]> appointments ;

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public void deleteAppointment(LocalDate date) {
        if (appointments.containsKey(date)) {
            appointments.remove(date);
        }
    }

    public HashMap<LocalDate, Appointment[]> getAppointments() {
        return appointments;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Patient(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.address = address;
        this.type = type;
        this.dossier = dossier;
    }

    public Patient() {

    }

    void ConsulterDossier(){

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setType(EPatient type) {
        this.type = type;
    }

    public void setUrgent(Boolean urgent) {
        Urgent = urgent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EPatient getType() {
        return type;
    }
    public void addAppointment(LocalDate date, Appointment newAppointment) {
        if (appointments == null) {
            appointments = new HashMap<>();
        }
        if (appointments.containsKey(date)) {
            Appointment[] existingAppointments = appointments.get(date);
            Appointment[] updatedAppointments = Arrays.copyOf(existingAppointments, existingAppointments.length + 1);
            updatedAppointments[updatedAppointments.length - 1] = newAppointment;
            appointments.put(date, updatedAppointments);
        } else {
            appointments.put(date, new Appointment[]{ newAppointment });
        }
    }

    public boolean checkDossier(){
        return this.dossier.getNumDossier() != -1;
    }

}
