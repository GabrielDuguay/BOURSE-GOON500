import bourse.ListeValeursBoursieres;

public class Main {
    public static void main(String[] args) {
        int choix = 3;
        System.out.println("---------- BOURSE & GOON 500 ----------");
        do {
            choix = Util.lireInt("1. Charger les données\n2. Afficher toutes les entreprises\n3. Quitter\n");
            if (choix > 3 || choix < 1) {
                System.out.println("Entrée invalide. Veuillez entrer un entier parmis les choix suivants:\n------------------------------");
            }
        } while (choix > 3 || choix < 1);

        if (choix == 1) {

            Util.tempsChargement("Chargement des données du NASDAQ.", 2);
            ListeValeursBoursieres liste = new ListeValeursBoursieres();
            liste.chargerDepuisCSV();
        }
        if (choix == 2) {
            System.out.println("Toutes les entreprises...");
        }
        if (choix == 3) {
            System.out.println("Au revoir!");
        }

    }
}