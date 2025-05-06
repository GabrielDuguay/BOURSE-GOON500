package bourse;

import java.util.Scanner;

public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lit un entier depuis la console avec validation.
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
     */
    public static String lireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void tempsChargement(String message, int secondes) {
        System.out.print(message);
        try {
            for (int i = 0; i < (secondes * 1); i++) {
                Thread.sleep(500); // 150 ms
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println("\nTerminé !");
        } catch (InterruptedException e) {
            System.out.println("Chargement interrompu.");
        }
    }

    public static double toDouble(String texte){
        if (texte == null || texte.trim().isEmpty() || texte.trim().equalsIgnoreCase("null")) {
            return 0.0;
        }

        try {
            // Retirer les symboles inutiles comme $, %, , etc.
            String nettoye = texte.replaceAll("[$%,]", "").trim();
            return Double.parseDouble(nettoye);
        } catch (NumberFormatException e) {
            System.out.println("Impossible de convertir en double : " + texte);
            return 0.0;
        }
    }

    public static int toInteger(String texte){
        if (texte == null || texte.trim().isEmpty() || texte.trim().equalsIgnoreCase("null")) {
            return 0;
        }

        try {
            // Retirer les symboles inutiles comme $, %, , etc.
            String nettoye = texte.replaceAll("[$%,]", "").trim();
            return Integer.parseInt(nettoye);
        } catch (NumberFormatException e) {
            System.out.println("Impossible de convertir en double : " + texte);
            return 0;
        }
    }
}