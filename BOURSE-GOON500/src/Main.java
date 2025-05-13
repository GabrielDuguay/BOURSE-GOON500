import bourse.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        ListeValeursBoursieres liste = new ListeValeursBoursieres();
        boolean donneesChargees = false;
        int choix = 0;

        do {
            printTitle("\u001B[1;32m" + "---------- BOURSE & GOON 500 ----------", 30);
            String entree = Util.lireString("""
                    1. Charger les données
                    2. Sélectionner un secteur
                    3. Voir les statistiques globales
                    4. Afficher les meilleurs secteurs
                    5. Quitter
                    """);

            if (entree.equalsIgnoreCase("GOON")) {
                afficherCredits();
                continue;
            }

            try {
                choix = Integer.parseInt(entree);
            } catch (NumberFormatException e) {
                choix = -1;
            }

            if (choix < 1 || choix > 5) {
                System.out.println("Entrée invalide. Veuillez entrer un entier parmi les choix suivants :\n---------------------------------------");
                continue;
            }

            if (choix == 1) {
                if (donneesChargees) {
                    System.out.println("Les données du NASDAQ ont déjà été chargées!");
                    Thread.sleep(1250);
                } else {
                    Util.tempsChargement("Chargement des données du NASDAQ...", 2);
                    liste.chargerDepuisCSV();
                    donneesChargees = true;
                }

            } else if (choix == 2) {
                if (!donneesChargees) {
                    System.out.println("Veuillez d'abord charger les données avec l'option 1.");
                    continue;
                }

                System.out.println("Types de secteurs disponibles :");
                for (TypeSecteur ts : TypeSecteur.values()) {
                    System.out.println("- " + ts);
                }

                String secteurTexte = Util.lireString("Entrez le nom exact d’un secteur parmi ceux ci-dessus :");
                TypeSecteur secteurChoisi = null;
                try {
                    secteurChoisi = TypeSecteur.valueOf(secteurTexte.trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Secteur invalide. Retour au menu principal.");
                    continue;
                }

                var entreprisesSecteur = liste.triSecteur(secteurChoisi);
                if (entreprisesSecteur.isEmpty()) {
                    System.out.println("Aucune entreprise trouvée dans ce secteur.");
                    continue;
                }

                int sousChoix;
                do {
                    System.out.println("\n--- Entreprises du secteur " + secteurChoisi + " ---");
                    sousChoix = Util.lireInt("""
                            1. Afficher toutes les entreprises
                            2. Afficher les meilleures compagnies du secteur
                            3. Voir les statistiques du secteur
                            4. Retour
                            """);

                    if (sousChoix == 1) {
                        for (ValeurBoursiere vb : entreprisesSecteur) {
                            System.out.println(vb);
                        }

                    } else if (sousChoix == 2) {
                        int max = entreprisesSecteur.size();
                        int nb = -1;
                        while (nb < 1 || nb > max) {
                            try {
                                nb = Util.lireInt("Combien de compagnies voulez-vous afficher? (entre 1 et " + max + ") ");
                                if (nb < 1 || nb > max) {
                                    System.out.println("Veuillez entrer un nombre valide entre 1 et " + max + ".");
                                }
                            } catch (Exception e) {
                                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                            }
                        }

                        entreprisesSecteur.sort((v1, v2) -> Double.compare(v2.getPourcentageChangement(), v1.getPourcentageChangement()));

                        System.out.println("\nTop " + nb + " des compagnies du secteur " + secteurChoisi + " selon le pourcentage de changement :\n");
                        for (int i = 0; i < nb; i++) {
                            ValeurBoursiere vb = entreprisesSecteur.get(i);
                            System.out.printf("%2d. %s | Changement: %.2f%%\n", i + 1, vb.getNom(), vb.getPourcentageChangement());
                        }
                        System.out.println();

                    } else if (sousChoix == 3) {
                        liste.afficherStatistiquesPourSecteur(secteurChoisi);
                    }

                } while (sousChoix != 4);

            } else if (choix == 3) {
                if (donneesChargees) {
                    liste.afficherStatistiquesGlobales();
                } else {
                    System.out.println("Veuillez d'abord charger les données avec l'option 1.");
                }

            } else if (choix == 4) {
                if (donneesChargees) {
                    liste.afficherClassementDesSecteurs();
                } else {
                    System.out.println("Veuillez d'abord charger les données avec l'option 1.");
                }
            }

        } while (choix != 5);

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
        System.out.println(); // saut de ligne
    }

    private static void afficherCredits() throws Exception {
        System.out.println("\n\u001B[1;36m✨ CRÉDITS ✨\u001B[0m");
        Thread.sleep(500);
        System.out.println("Une production maison signée :\n");
        Thread.sleep(700);
        System.out.println("\u001B[1;33m🎩 Gabriel Duguay\u001B[0m — Lead développeur, visionnaire du GOON 500™");
        Thread.sleep(700);
        System.out.println("\u001B[1;35m🧠 Steven Rosberry\u001B[0m — Stratège boursier, gooner en chef");
        Thread.sleep(700);
        System.out.println("\u001B[1;32m🤖 ChatGPT (OpenAI)\u001B[0m — Assistant IA fidèle, shoutout OpenAI");
        Thread.sleep(1000);
        System.out.println("\nMerci d’utiliser \u001B[1;32mBOURSE & GOON 500 🤑📈\u001B[0m");
        System.out.println("Appuyez sur Entrée pour revenir au menu principal.");
        System.in.read();
    }
}
