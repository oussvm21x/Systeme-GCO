package BaseClasses.Appointments;

import Enums.EAppointment;
import Enums.EPatient;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends Appointment{
    private String firstNamePatient ;
    private String lastNamePateint ;
    private int agePateint ;
    private EPatient pateint ;
    public Consultation(LocalDate date, LocalTime hour, LocalTime duration, EAppointment appointmentType , String firstNamePatient , String lastNamePateint , int agePateint , EPatient pateint) {
        super(date , hour, duration , appointmentType);
        this.firstNamePatient = firstNamePatient ;
        this.lastNamePateint = lastNamePateint ;
        this.agePateint = agePateint ;
        this.pateint = pateint;
    }

    public Consultation() {

    }


    // Getters et setters pour address
    @Override
    public void cosnulterObservation() {

    }

}
