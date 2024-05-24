package BaseClasses.Bilan;

import BaseClasses.Test.Test;

public class ClinicalTest extends Etape{
    private String observationClinique ;
    private Test test ;
    private Integer num ;
    private String titre ;
    private int id ;
    private static int nb=0 ;


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getnum() {
        return num;
    }

    public void setnum(Integer num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public ClinicalTest() {
        this.id=nb ;
        nb++;
        Test e = new Test("test");
        this.test =e;
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
