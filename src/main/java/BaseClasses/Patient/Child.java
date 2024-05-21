package BaseClasses.Patient;

import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.time.LocalDate;

public class Child extends Patient {
    String studieLevel ;
    String[] parentsNums = new String[2];
    public Child(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier , String studieLevel ) {
        super(firstName, lastName, birthDate, birthPlace, address, type, dossier);
        this.studieLevel = studieLevel ;

    }
    public Child( ) {


    }

    public String getStudieLevel() {
        return studieLevel;
    }

    public String[] getParentsNums() {
        return parentsNums;
    }

    public void setParentsNums(String[] parentsNums) {
        this.parentsNums = parentsNums;
    }

    public void setStudieLevel(String studieLevel) {
        this.studieLevel = studieLevel;
    }
    public void setnumP(String num){
        parentsNums[0] =num;
    }
    public void setnumM(String num){
        parentsNums[1] =num;
    }
}
