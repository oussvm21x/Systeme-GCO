import BaseClasses.src.Objectif;
import Enums.EAppointment;
import Enums.EMode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FollowUp extends Appointment {
    private int medFileNum;
    private EMode mode;
    private final LocalTime duration = LocalTime.of(1, 0);
    private List<Objectif> objectifs;

    public FollowUp(LocalDate date, LocalTime hour, LocalTime duration, EAppointment appointmentType, EMode mode) {
        super(date, hour, duration, appointmentType);
        this.mode = mode;
    }

    public int getMedFileNum() {
        return medFileNum;
    }

    public void setMedFileNum(int medFileNum) {
        this.medFileNum = medFileNum;
    }

    public EMode getMode() {
        return mode;
    }

    public void setMode(EMode mode) {
        this.mode = mode;
    }

    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    @Override
    public void cosnulterObservation() {

    }
}
