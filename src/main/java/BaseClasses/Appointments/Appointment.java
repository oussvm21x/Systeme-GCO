package BaseClasses.Appointments;

import BaseClasses.Patient.Patient;
import BaseClasses.src.Observation;
import Enums.EAppointment;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Appointment {
    protected LocalDate date;
    protected LocalTime hour;
    protected LocalTime duration;
    protected EAppointment appointmentType;
    protected Observation observation;
    protected List<Patient> Patients;

    public Appointment() {

    }



    public Appointment(LocalDate date, LocalTime hour, LocalTime duration, EAppointment appointmentType) {
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
    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    // Getter and setter for duration
    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
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
}


