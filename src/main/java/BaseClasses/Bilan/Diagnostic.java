package BaseClasses.Bilan;

public class Diagnostic extends Bilan{
    private String Description ;
    private boolean troubles_deglutition =false;
    private boolean troubles_neuro_developpement =false ;
    private boolean troubles_cognitifs  =false;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTroubles_cognitifs(boolean troubles_cognitifs) {
        this.troubles_cognitifs = troubles_cognitifs;
    }

    public void setTroubles_deglutition(boolean troubles_deglutition) {
        this.troubles_deglutition = troubles_deglutition;
    }

    public void setTroubles_neuro_developpement(boolean troubles_neuro_developpement) {
        this.troubles_neuro_developpement = troubles_neuro_developpement;
    }
}
