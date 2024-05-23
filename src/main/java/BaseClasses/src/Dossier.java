package BaseClasses.src;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Bilan.Anamnese;
import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.*;

public class Dossier implements Serializable {
    int numDossier = -1;
    List<Bilan> bilans = new ArrayList<Bilan>() ;
    List<Appointment> appointments ;
    List<FicheSuivi> fichesSuivis  ;
    static int nbdossier;

    //constructor
    public Dossier(int numDossier, List<Bilan> bilans, List<Appointment> appointments, List<FicheSuivi> fichesSuivis) {
        this.numDossier = numDossier;
        this.bilans = bilans;
        this.appointments = appointments;
        this.fichesSuivis = fichesSuivis;
    }
    public Dossier(){
setNumDossier(nbdossier);
        nbdossier++;
        Bilan b = new Bilan();
        b.setTitle("Premier Bilan Ortophoniste");
        b.setId(0);
        bilans.add(b);
        System.out.println("bilan0 "+ bilans);
    }

    //getters and setters
    public int getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(int numDossier) {
        this.numDossier = numDossier;
    }

    public List<Bilan> getBilans() {
        return bilans;
    }

    public void setBilans(List<Bilan> bilans) {
        this.bilans = bilans;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<FicheSuivi> getFichesSuivis() {
        return fichesSuivis;
    }

    public void setFichesSuivis(List<FicheSuivi> fichesSuivis) {
        this.fichesSuivis = fichesSuivis;
    }

    //methods
    public void addBilan(Bilan bilan){
        this.bilans.add(bilan);
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public void addFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuivis.add(ficheSuivi);
    }

    public void deleteBilan(Bilan bilan){
        this.bilans.remove(bilan);
    }

    public void deleteAppointment(Appointment appointment){
        this.appointments.remove(appointment);
    }

    public void deleteFicheSuivi(FicheSuivi ficheSuivi){
        this.fichesSuivis.remove(ficheSuivi);
    }

    public void visualiserApointments(){

    }


}
