package tests;

import bourse.ListeValeursBoursieres;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ListeValeursBoursieresTest {
    @Test
    void chargerDepuisCSV_nbValeursAttendu() {

        ListeValeursBoursieres liste = new ListeValeursBoursieres();
        liste.chargerDepuisCSV();

        // Vérifie que la liste a le bon nombre de valeurs
        assertEquals(6861, liste.getValeursBoursieres().size());
    }
}
