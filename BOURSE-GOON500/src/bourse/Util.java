package bourse;

import java.util.Scanner;

/**
 * Classe utilitaire fournissant des méthodes de lecture depuis la console,
 * de conversion de types, et d'affichage avec délai simulé.
 * <p>
 * Cette classe centralise les fonctions communes utiles dans un contexte
 * de traitement de données boursières ou d'interaction utilisateur.
 * </p>
 *
 * @author ChatGPT
 */
public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lit un entier depuis la console, avec validation de l'entrée.
     *
     * @param message Le message affiché à l'utilisateur.
     * @return L'entier saisi par l'utilisateur.
     */
    public static int lireInt(String message) {
        int valeur;
        while (true) {
            System.out.print(message);
            try {
                valeur = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un entier.");
            }
        }
        return valeur;
    }

    /**
     * Lit une chaîne de caractères depuis la console.
     *
     * @param message Le message affiché à l'utilisateur.
     * @return La chaîne saisie par l'utilisateur.
     */
    public static String lireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Affiche un message de chargement avec des points animés pendant un certain nombre de secondes.
     *
     * @param message  Le message de base à afficher avant les points.
     * @param secondes La durée totale du chargement simulé.
     */
    public static void tempsChargement(String message, int secondes) {
        System.out.print(message);
        try {
            for (int i = 0; i < secondes; i++) {
                Thread.sleep(500); // 0.5 seconde
                System.out.print(".");
                Thread.sleep(500); // encore 0.5 seconde
            }
            System.out.println("\nTerminé !");
        } catch (InterruptedException e) {
            System.out.println("Chargement interrompu.");
        }
    }

    /**
     * Convertit un texte en double, en nettoyant les symboles courants ($, %, virgule).
     *
     * @param texte Le texte à convertir.
     * @return Le double correspondant, ou 0.0 si la conversion échoue.
     */
    public static double toDouble(String texte) {
        if (texte == null || texte.trim().isEmpty() || texte.trim().equalsIgnoreCase("null")) {
            return 0.0;
        }

        try {
            String nettoye = texte.replaceAll("[$%,]", "").trim();
            return Double.parseDouble(nettoye);
        } catch (NumberFormatException e) {
            System.out.println("Impossible de convertir en double : " + texte);
            return 0.0;
        }
    }

    /**
     * Convertit un texte en entier, en nettoyant les symboles courants ($, %, virgule).
     *
     * @param texte Le texte à convertir.
     * @return L'entier correspondant, ou 0 si la conversion échoue.
     */
    public static int toInteger(String texte) {
        if (texte == null || texte.trim().isEmpty() || texte.trim().equalsIgnoreCase("null")) {
            return 0;
        }

        try {
            String nettoye = texte.replaceAll("[$%,]", "").trim();
            return Integer.parseInt(nettoye);
        } catch (NumberFormatException e) {
            System.out.println("Impossible de convertir en entier : " + texte);
            return 0;
        }
    }
}
