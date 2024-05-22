package BaseClasses.Appointments;

import Enums.EAppointment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Atelier extends Appointment  implements Serializable {
    private String themathique ;
    List<Integer> patientMedFiles ;

    public Atelier(LocalDate date, Integer hour, Integer duration, EAppointment appointmentType , String themathique) {
        super(date, hour, duration, appointmentType);
        this.themathique = themathique ;
    }

    public Atelier() {

    }

    public String getThemathique() {
        return themathique;
    }

    public void setThemathique(String themathique) {
        this.themathique = themathique;
    }

    public void setPatientMedFiles(List<Integer> patientMedFiles){
        this.patientMedFiles = patientMedFiles ;
    }

    @Override
    public void cosnulterObservation() {

    }
}
