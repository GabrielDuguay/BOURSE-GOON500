package Bourse;

public class ValeurBoursiere {

    private String symbole;
    private String nom;
    private double derniereVente;
    private double changementNet;
    private double pourcentageChangement;
    private double capitalisationBoursiere;
    private String pays;
    private int anneeEntreeEnMarche;
    private int volume;
    private TypeSecteur secteur;
    private String industrie;

    public ValeurBoursiere(String symbole, String nom, double derniereVente, double changementNet, double pourcentageChangement, double capitalisationBoursiere, String pays, int anneeEntreeEnMarche, int volume, TypeSecteur secteur, String industrie) {
        this.symbole = symbole;
        this.nom = nom;
        this.derniereVente = derniereVente;
        this.changementNet = changementNet;
        this.pourcentageChangement = pourcentageChangement;
        this.capitalisationBoursiere = capitalisationBoursiere;
        this.pays = pays;
        this.anneeEntreeEnMarche = anneeEntreeEnMarche;
        this.volume = volume;
        this.secteur = secteur;
        this.industrie = industrie;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getDerniereVente() {
        return derniereVente;
    }

    public void setDerniereVente(double derniereVente) {
        this.derniereVente = derniereVente;
    }

    public double getChangementNet() {
        return changementNet;
    }

    public void setChangementNet(double changementNet) {
        this.changementNet = changementNet;
    }

    public double getPourcentageChangement() {
        return pourcentageChangement;
    }

    public void setPourcentageChangement(double pourcentageChangement) {
        this.pourcentageChangement = pourcentageChangement;
    }

    public double getCapitalisationBoursiere() {
        return capitalisationBoursiere;
    }

    public void setCapitalisationBoursiere(double capitalisationBoursiere) {
        this.capitalisationBoursiere = capitalisationBoursiere;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getAnneeEntreeEnMarche() {
        return anneeEntreeEnMarche;
    }

    public void setAnneeEntreeEnMarche(int anneeEntreeEnMarche) {
        this.anneeEntreeEnMarche = anneeEntreeEnMarche;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public TypeSecteur getSecteur() {
        return secteur;
    }

    public void setSecteur(TypeSecteur secteur) {
        this.secteur = secteur;
    }

    public String getIndustrie() {
        return industrie;
    }

    public void setIndustrie(String industrie) {
        this.industrie = industrie;
    }

    @Override
    public String toString() {
        return "ValeurBoursiere{" +
                "symbole='" + symbole + '\'' +
                ", nom='" + nom + '\'' +
                ", derniereVente=" + derniereVente +
                ", changementNet=" + changementNet +
                ", pourcentageChangement=" + pourcentageChangement +
                ", capitalisationBoursiere=" + capitalisationBoursiere +
                ", pays='" + pays + '\'' +
                ", anneeEntreeEnMarche=" + anneeEntreeEnMarche +
                ", volume=" + volume +
                ", secteur=" + secteur +
                ", industrie='" + industrie + '\'' +
                '}';
    }
}
