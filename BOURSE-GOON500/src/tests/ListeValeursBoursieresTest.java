package tests;

import bourse.ListeValeursBoursieres;
import bourse.TypeSecteur;
import bourse.ValeurBoursiere;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListeValeursBoursieresTest {

    private ListeValeursBoursieres liste;
    private ValeurBoursiere vb1, vb2, vb3;

    @BeforeEach
    void setUp() {
        liste = new ListeValeursBoursieres();

        vb1 = new ValeurBoursiere("AAA", "Compagnie A", 100, 5, 0.05, 1_000_000, "Canada", 2000, 5000, TypeSecteur.ENERGIE);
        vb2 = new ValeurBoursiere("BBB", "Compagnie B", 200, -10, -0.05, 2_000_000, "USA", 2010, 6000, TypeSecteur.TECHNOLOGIE);
        vb3 = new ValeurBoursiere("CCC", "Compagnie C", 150, 0, 0.00, 1_500_000, "France", 2005, 5500, TypeSecteur.ENERGIE);

        liste.getValeursBoursieres().add(vb1);
        liste.getValeursBoursieres().add(vb2);
        liste.getValeursBoursieres().add(vb3);
    }

    @Test
    void testTriPourcentageChangement() {
        ArrayList<ValeurBoursiere> triees = liste.triPourcentageChangement();
        assertEquals(vb1, triees.get(0));
        assertEquals(vb3, triees.get(1));
        assertEquals(vb2, triees.get(2));
    }

    @Test
    void testTriSecteur_retourneSeulementLeSecteurDemandé() {
        ArrayList<ValeurBoursiere> secteurEnergie = liste.triSecteur(TypeSecteur.ENERGIE);
        assertEquals(2, secteurEnergie.size());
        assertTrue(secteurEnergie.contains(vb1));
        assertTrue(secteurEnergie.contains(vb3));
        assertFalse(secteurEnergie.contains(vb2));
    }

    @Test
    void testToString_nonVideSiValeursAjoutees() {
        String sortie = liste.toString();
        assertTrue(sortie.contains("Compagnie A"));
        assertTrue(sortie.contains("Compagnie B"));
    }

    @Test
    void testAfficherTopPourcentageChangement() {
        String output = capturerSortie(() -> liste.afficherTopPourcentageChangement(2));
        assertTrue(output.contains("Compagnie A"));
        assertTrue(output.contains("Compagnie C"));
    }

    @Test
    void testAfficherStatistiquesGlobales() {
        String output = capturerSortie(() -> liste.afficherStatistiquesGlobales());
        assertTrue(output.contains("Moyenne"));
        assertTrue(output.contains("Médiane"));
        assertTrue(output.contains("Écart-type"));
    }

    @Test
    void testAfficherStatistiquesPourSecteur_avecDonnees() {
        String output = capturerSortie(() -> liste.afficherStatistiquesPourSecteur(TypeSecteur.ENERGIE));
        assertTrue(output.contains("Statistiques pour le secteur"));
        assertTrue(output.contains("Compagnie A") || output.contains("Moyenne")); // selon sortie formatée
    }

    @Test
    void testAfficherClassementDesSecteurs() {
        String output = capturerSortie(() -> liste.afficherClassementDesSecteurs());
        assertTrue(output.contains("Classement des secteurs"));
        assertTrue(output.contains("ENERGIE"));
        assertTrue(output.contains("TECHNOLOGIE"));
    }

    // Utilitaire pour capturer le texte imprimé dans la console
    private String capturerSortie(Runnable bloc) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream sortieCapturée = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sortieCapturée));

        try {
            bloc.run();
        } finally {
            System.setOut(originalOut);
        }

        return sortieCapturée.toString();
    }
}
