package BaseClasses.src;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Patient.Adult;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Observation  implements Serializable {
    private String content;
    private Appointment appointment;
    private Adult adult ;
    private LocalDate date;
    private LocalTime hour;

    public Observation(String content, Appointment appointment, LocalDate date, LocalTime hour) {
        this.content = content;
        this.appointment = appointment;
        this.date = date;
        this.hour = hour;
    }

    // Getters and setters for content, appointment, date, and hour
    // Getters and setters for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getters and setters for appointment
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    // Getters and setters for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getters and setters for hour
    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
}
