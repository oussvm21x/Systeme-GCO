import Enums.EAppointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Atelier extends Appointment {
    private String themathique ;
    List<Integer> patientMedFiles ;
    private final LocalTime duration = LocalTime.of(1, 0);
    public Atelier(LocalDate date, LocalTime hour, LocalTime duration, EAppointment appointmentType , String themathique) {
        super(date, hour, duration, appointmentType);
        this.themathique = themathique ;
    }

    public void setPatientMedFiles(List<Integer> patientMedFiles){
        this.patientMedFiles = patientMedFiles ;
    }

    @Override
    public void cosnulterObservation() {

    }
}
