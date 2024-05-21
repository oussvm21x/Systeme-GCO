package BaseClasses.Appointments;

import BaseClasses.Patient.Patient;
import BaseClasses.src.Observation;
import Enums.EAppointment;
import Enums.EMode;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Appointment implements Serializable {
    private static final long serialVersionUID = 123456789L;
    protected LocalDate date;
    protected Integer hour;
    protected Integer duration = 90;;
    protected EAppointment appointmentType;
    protected Observation observation;
    protected List<Patient> Patients;
    protected String title ;
    private EMode mode;

    public Appointment() {

    }

    public void setMode(EMode mode) {
        this.mode = mode;
    }

    public Appointment(LocalDate date, Integer hour, Integer duration, EAppointment appointmentType) {
        this.date = date;
        this.hour = hour;
        this.duration = duration;
        this.appointmentType = appointmentType;
    }

    // Getters and setters for date, hour, duration, and appointmentType
    public Observation getObservation() {
        return observation;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }
    //Getter and setter for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter and setter for hour
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    // Getter and setter for duration
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    // Getter and setter for appointmentType
    public EAppointment getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(EAppointment appointmentType) {
        this.appointmentType = appointmentType;
    }
    public abstract void cosnulterObservation();

    public void setPatients(List<Patient> patients) {
        if(this.Patients == null){
            this.Patients = new ArrayList<>();
        }
        Patients = patients;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Patient> getPatients() {
        return Patients;
    }
}


