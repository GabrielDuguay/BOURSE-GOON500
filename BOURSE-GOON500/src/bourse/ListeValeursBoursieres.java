package bourse;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une collection de {@link ValeurBoursiere} pouvant être chargée depuis un fichier CSV.
 * <p>
 * Cette classe lit un fichier contenant des informations boursières ligne par ligne,
 * convertit les données textuelles en objets {@link ValeurBoursiere}, et stocke le tout
 * dans une liste.
 * </p>
 * Le chemin du fichier CSV est défini automatiquement selon l'arborescence du projet
 * (chemin relatif vers le dossier "donnees").
 *
 * @author ChatGPT (OpenAI)
 *
 */
public class ListeValeursBoursieres {
    private static final char fSep = File.separatorChar;

    /**
     * Chemin d'accès au fichier CSV à partir du répertoire du projet.
     */
    private static final String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnees" + fSep + "nasdaq.csv";

    private ArrayList<ValeurBoursiere> valeursBoursieres;

    /**
     * Constructeur par défaut. Initialise une liste vide de valeurs boursières.
     */
    public ListeValeursBoursieres() {
        valeursBoursieres = new ArrayList<>();
    }

    /**
     * Charge les données à partir d’un fichier CSV situé dans le dossier de données du projet.
     * <p>
     * Chaque ligne du fichier est lue et transformée en un objet {@link ValeurBoursiere}.
     * Le champ "secteur" est converti en {@link TypeSecteur} via la classe {@link ConvertisseurSecteur}.
     * <p>
     *
     * Format attendu (ordre des colonnes) :
     * symbole, nom, derniereVente, changementNet, pourcentageChangement, capitalisationBoursiere,
     * pays, anneeEntreeEnMarche, volume, secteur, industrie
     * <p>
     *
     *
     * Les erreurs de lecture ou de format sont capturées via des exceptions.
     *
     */
    public void chargerDepuisCSV() {
        String ligne;
        ConvertisseurSecteur convertisseur = new ConvertisseurSecteur();

        valeursBoursieres = new ArrayList<>();

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(pathIn));

            ligne = fichier.readLine();
            ligne = fichier.readLine();


            while (ligne != null) {
                String[] valeurs = ligne.split(",");
                String symbole = valeurs[0];
                String nom = valeurs[1];
                double derniereVente = Util.toDouble(valeurs[2]);
                double changementNet = Util.toDouble(valeurs[3]);
                double pourcentageChangement = Util.toDouble(valeurs[4]);
                double capitalisationBoursiere = Util.toDouble(valeurs[5]);
                String pays = valeurs[6];
                int anneeEntreeEnMarche = Util.toInteger(valeurs[7]);
                int volume = Util.toInteger(valeurs[8]);
                String secteurTexte = valeurs[9];

                TypeSecteur typeSecteur = convertisseur.convertir(secteurTexte.trim());

                ValeurBoursiere vb = new ValeurBoursiere(symbole, nom, derniereVente, changementNet,
                        pourcentageChangement, capitalisationBoursiere, pays, anneeEntreeEnMarche, volume,
                        typeSecteur);

                valeursBoursieres.add(vb);

                ligne = fichier.readLine();
            }

            fichier.close();

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e);
        }
    }

    public ArrayList<ValeurBoursiere> getValeursBoursieres() {
        return valeursBoursieres;
    }

    public ArrayList<ValeurBoursiere> triPourcentageChangement() {
        ArrayList<ValeurBoursiere> copieTrie = new ArrayList<>(valeursBoursieres); // copier les données existantes
        copieTrie.sort((v1, v2) -> Double.compare(v2.getPourcentageChangement(), v1.getPourcentageChangement())); // tri décroissant
        return copieTrie;
    }

    //crée un tableau avec le secteur spécifié seulement et non un trisecteur -> ☢️
    public ArrayList<ValeurBoursiere> triSecteur(TypeSecteur secteurDemandé) {
        ArrayList<ValeurBoursiere> copieTrie = new ArrayList<>(); // copier les données existants

        for (ValeurBoursiere vb : valeursBoursieres) { // filtre TypeSecteur
            if (vb.getSecteur() == secteurDemandé) {
                copieTrie.add(vb);
            }
        }

        return copieTrie;
    }


    public void afficherTopPourcentageChangement(int nb) {
        ArrayList<ValeurBoursiere> top = triPourcentageChangement();
        System.out.println("\nTop " + nb + " des compagnies selon le pourcentage de changement :\n");

        for (int i = 0; i < Math.min(nb, top.size()); i++) {
            ValeurBoursiere vb = top.get(i);
            System.out.printf("%2d. %s | Changement: %.2f%%\n", i + 1, vb.getNom(), vb.getPourcentageChangement());
        }
        System.out.println();
    }


    /**
     * Retourne une chaîne représentant toutes les valeurs boursières chargées.
     *
     * @return Une chaîne contenant un résumé texte de chaque {@link ValeurBoursiere}
     */

    @Override
    public String toString() {
        StringBuilder retour = new StringBuilder();
        for (ValeurBoursiere vb : valeursBoursieres) {
            retour.append(vb.toString()).append("\n");
        }
        return retour.toString();
    }
}
