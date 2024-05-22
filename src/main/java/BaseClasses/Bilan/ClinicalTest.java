package BaseClasses.Bilan;

import BaseClasses.Test.Test;

public class ClinicalTest extends Etape{
    private String observationClinique ;
    private Test test ;

    public ClinicalTest(String observationClinique, Test test) {

    }
    //getters and setters
    public String getObservationClinique() {
        return observationClinique;
    }

    public void setObservationClinique(String observationClinique) {
        this.observationClinique = observationClinique;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    //needed methods





}
