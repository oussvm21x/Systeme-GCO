import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.time.LocalDate;

abstract class Patient {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
    protected String birthPlace;
    protected String address;
    protected EPatient type;
    protected Dossier dossier;

    public Patient(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.address = address;
        this.type = type;
        this.dossier = dossier;
    }

    void ConsulterDossier(){

    }
}
