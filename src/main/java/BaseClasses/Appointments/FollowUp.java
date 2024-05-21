package BaseClasses.Appointments;

import BaseClasses.src.Objectif;
import Enums.EAppointment;
import Enums.EMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FollowUp extends Appointment  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int medFileNum;

    //private List<Objectif> objectifs;

    public FollowUp(LocalDate date, Integer hour, Integer duration, EAppointment appointmentType, EMode mode) {
        super(date, hour, duration, appointmentType);
    }
    public FollowUp() {
        super();
        return;
    }

    public int getMedFileNum() {
        return medFileNum;
    }

    public void setMedFileNum(int medFileNum) {
        this.medFileNum = medFileNum;
    }



   /* public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }*/

    @Override
    public void cosnulterObservation() {

    }

}
