package BaseClasses.Bilan;

import BaseClasses.Patient.Patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bilan implements Serializable {
    private AnamneseAdult etape1;
    private AnamneseKid etape11;
    private List<ClinicalTest> etape2;
    private Diagnostic etape3;
    private TeurapeuticProject etape4;
    private Patient patient;
    private String title;
    private int id;

    // Constructor
    public Bilan() {
        this.etape2 = new ArrayList<>();
    }

    // Getters and setters
    public Anamnese getEtape1() {
        return etape1;
    }

    public Diagnostic getEtape3() {
        return etape3;
    }

    public TeurapeuticProject getEtape4() {
        return etape4;
    }

    public void setEtape1(Anamnese etape1) {
        this.etape1 = (AnamneseAdult) etape1;
    }

    public List<ClinicalTest> getEtape2() {
        return etape2;
    }

    public void setEtape2(List<ClinicalTest> etape2) {
        this.etape2 = etape2;
    }

    public void setEtape3(Diagnostic etape3) {
        this.etape3 = etape3;
    }

    public void setEtape4(TeurapeuticProject etape4) {
        this.etape4 = etape4;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Bilan newBilan(Patient patient) {
        if (patient.checkDossier()) {
            return new Bilan();
        } else {
            return null;
        }
    }

    // Method to add a ClinicalTest
    public void addClinicalTest(ClinicalTest test) {
        if (etape2 == null) {
            etape2 = new ArrayList<>();
        }
        etape2.add(test);
    }
}
