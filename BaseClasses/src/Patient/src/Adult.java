import BaseClasses.src.Dossier;
import Enums.EPatient;

import java.time.LocalDate;


public class Adult extends Patient{
    private String diplome ;
    private String profession ;
    private String phoneNum ;
    public Adult(String firstName, String lastName, LocalDate birthDate, String birthPlace, String address, EPatient type, Dossier dossier , String phoneNum , String profession , String diplome) {
        super(firstName, lastName, birthDate, birthPlace, address, type, dossier);
        this.phoneNum = phoneNum ;
        this.diplome = diplome ;
        this.profession = profession ;
    }
}
