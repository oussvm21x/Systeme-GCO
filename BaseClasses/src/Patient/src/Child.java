import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.time.LocalDate;

public class Child extends Patient{
    String studieLevel ;
    String[] parentsNums ;
    public Child(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier , String studieLevel , String[] parentsNums) {
        super(firstName, lastName, birthDate, birthPlace, address, type, dossier);
        this.studieLevel = studieLevel ;
        this.parentsNums = parentsNums ;
    }
}
