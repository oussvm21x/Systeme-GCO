package BaseClasses.Patient;

import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.time.LocalDate;


public class Adult extends Patient {
    private String diplome ;
    private String profession ;
    private String phoneNum ;
    public Adult(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier , String phoneNum , String profession , String diplome) {
        super(firstName, lastName, birthDate, birthPlace, address, type, dossier);
        this.phoneNum = phoneNum ;
        this.diplome = diplome ;
        this.profession = profession ;
    }
    public Adult() {

    }

    public String getDiplome() {
        return diplome;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getProfession() {
        return profession;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
