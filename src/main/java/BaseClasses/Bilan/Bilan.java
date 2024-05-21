package BaseClasses.Bilan;


import BaseClasses.Patient.Patient;

import java.io.Serializable;
import java.util.Queue;

public class Bilan implements Serializable {
    private Queue<Etape> etapes;
    private Patient patient ;
    //constructeur
  /*  public Bilan(Queue<Etape> etapes, Patient patient) {
        this.etapes = etapes;
        this.patient = patient;
    }*/
    //getters et setters
    public Queue<Etape> getEtapes() {
        return etapes;
    }
    public void setEtapes(Queue<Etape> etapes) {
        this.etapes = etapes;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    //methode pour ajouter une etape
    public void addEtape(Etape etape){
        etapes.add(etape);
    }
    //methode pour supprimer une etape
    public void removeEtape(Etape etape){
        etapes.remove(etape);
    }
    //methode pour afficher les etapes
    public void displayEtapes(){
        for (Etape etape : etapes) {
            System.out.println(etape);
        }
    }

}
