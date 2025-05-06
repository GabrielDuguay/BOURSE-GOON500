package bourse;

/**
 * Représente une valeur boursière individuelle, avec ses caractéristiques financières
 * et son appartenance sectorielle.
 * <p>
 * Chaque instance correspond à une entreprise cotée en bourse, avec des données
 * telles que la dernière vente, le volume, le secteur économique, etc.
 * </p>
 *
 * @author ChatGPT (OpenAI)
 */
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

    /**
     * Constructeur principal pour créer une valeur boursière complète.
     *
     * @param symbole                 Le symbole boursier de l'entreprise (ex: AAPL)
     * @param nom                     Le nom de l'entreprise
     * @param derniereVente           Le dernier prix de vente enregistré
     * @param changementNet           Le changement net par rapport à la veille
     * @param pourcentageChangement   Le pourcentage de changement
     * @param capitalisationBoursiere La capitalisation boursière de l'entreprise
     * @param pays                    Le pays d'origine de l'entreprise
     * @param anneeEntreeEnMarche     L'année d'entrée sur le marché boursier
     * @param volume                  Le volume échangé
     * @param secteur                 Le secteur économique de l'entreprise (traduit en TypeSecteur)
     */
    public ValeurBoursiere(String symbole, String nom, double derniereVente, double changementNet,
                           double pourcentageChangement, double capitalisationBoursiere, String pays,
                           int anneeEntreeEnMarche, int volume, TypeSecteur secteur) {
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

    /**
     * Retourne une représentation textuelle complète de cette valeur boursière.
     *
     * @return Chaîne contenant tous les attributs principaux de l’objet.
     */
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
                ", secteur=" + secteur + '\'' +
                '}';
    }
}