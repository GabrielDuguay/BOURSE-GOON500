import bourse.ListeValeursBoursieres;
import bourse.Util;
import bourse.ValeurBoursiere;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ListeValeursBoursieres liste = new ListeValeursBoursieres();
        int choix;
        boolean donneeschargees = false;

        do {
            printTitle("\u001B[1;32m" + "---------- BOURSE & GOON 500 ----------", 75);
            //System.out.println("\n---------- BOURSE & GOON 500 ----------");
            do {
                choix = Util.lireInt("1. Charger les données\n2. Afficher toutes les entreprises\n3. Afficher les 10 meilleurs compagnies de la journée\n4. Quitter\n");
                if (choix > 3 || choix < 1) {
                    System.out.println("Entrée invalide. Veuillez entrer un entier parmis les choix suivants:\n------------------------------");
                }
            } while (choix > 4 || choix < 1);

            if (choix == 1) {

                if (donneeschargees) {
                    System.out.println("Les données du NASDAQ on déjà été chargé!");
                    try {
                        Thread.sleep(1250);
                    } catch (InterruptedException e) {
                        System.out.println("\nAffichage interrompu.");
                        break;
                    }
                } else {

                    Util.tempsChargement("Chargement des données du NASDAQ.", 2);
                    liste.chargerDepuisCSV();
                    donneeschargees = true;
                }
            }
            if (choix == 2) {
                if (donneeschargees) {
                    for (ValeurBoursiere vb : liste.getValeursBoursieres()) {
                        System.out.println(vb);
                    }
                } else {
                    System.out.println("Aucune donnée n'est chargée.");
                }
            }
            if (choix == 3) {
                if (donneeschargees) {

                }
            }
        } while (choix != 4);
        System.out.println("Au revoir!");
    }

    private static void printTitle(String texte, int delaiMillis) {
        for (char c : texte.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delaiMillis);
            } catch (InterruptedException e) {
                System.out.println("\nAffichage interrompu.");
                break;
            }
        }
        System.out.println(); // pour passer à la ligne à la fin
    }
}