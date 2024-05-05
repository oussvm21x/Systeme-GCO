package BaseClasses.src;

import Enums.EObjectif;

public class Objectif {
    private EObjectif type;
    private int note;
    private String enonce;

    // Constructor
    public Objectif(EObjectif type, int note, String enonce) {
        this.type = type;
        this.note = note;
        this.enonce = enonce;
    }

    // Getters
    public EObjectif getType() {
        return type;
    }

    public int getNote() {
        return note;
    }

    public String getEnonce() {
        return enonce;
    }

    // Setters
    public void setType(EObjectif type) {
        this.type = type;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
}
