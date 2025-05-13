package tests;

import bourse.ListeValeursBoursieres;
import bourse.TypeSecteur;
import bourse.ValeurBoursiere;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListeValeursBoursieresTest {
    @Test
    void chargerDepuisCSV_nbValeursAttendu() {

        ListeValeursBoursieres liste = new ListeValeursBoursieres();
        liste.chargerDepuisCSV();

        // Vérifie que la liste a le bon nombre de valeurs
        assertEquals(6861, liste.getValeursBoursieres().size());
    }

    @Test
    public void testTriPourcentageChangement() {
        ListeValeursBoursieres liste = new ListeValeursBoursieres();

        // Valeurs simulées
        ValeurBoursiere vb1 = new ValeurBoursiere("AAA", "Compagnie A", 100, 5, 0.05, 1000000, "Canada", 2000, 5000, TypeSecteur.ENERGIE);
        ValeurBoursiere vb2 = new ValeurBoursiere("BBB", "Compagnie B", 200, -10, -0.05, 2000000, "USA", 2010, 6000, TypeSecteur.TECHNOLOGIE);
        ValeurBoursiere vb3 = new ValeurBoursiere("CCC", "Compagnie C", 150, 0, 0.00, 1500000, "France", 2005, 5500, TypeSecteur.SANTE);

        liste.getValeursBoursieres().add(vb1);
        liste.getValeursBoursieres().add(vb2);
        liste.getValeursBoursieres().add(vb3);

        ArrayList<ValeurBoursiere> triees = liste.triPourcentageChangement();

        assertEquals(vb1, triees.get(0));
        assertEquals(vb3, triees.get(1));
        assertEquals(vb2, triees.get(2));
    }

}
