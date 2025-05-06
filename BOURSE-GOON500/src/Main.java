import bourse.ListeValeursBoursieres;
import bourse.Util;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int choix;
        boolean donneeschargees = false;

        do {
            printTitle("---------- BOURSE & GOON 500 ----------", 100);
            //System.out.println("\n---------- BOURSE & GOON 500 ----------");
            do {
                choix = Util.lireInt("1. Charger les données\n2. Afficher toutes les entreprises\n3. Quitter\n");
                if (choix > 3 || choix < 1) {
                    System.out.println("Entrée invalide. Veuillez entrer un entier parmis les choix suivants:\n------------------------------");
                }
            } while (choix > 3 || choix < 1);

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
                    ListeValeursBoursieres liste = new ListeValeursBoursieres();
                    liste.chargerDepuisCSV();
                    donneeschargees = true;
                }
            }
            if (choix == 2) {
                System.out.println("Toutes les entreprises...");
            }
        } while (choix != 3);
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