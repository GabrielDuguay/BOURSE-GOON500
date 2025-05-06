package tests;

import bourse.TypeSecteur;
import bourse.ValeurBoursiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValeurBoursiereTest {

    private ValeurBoursiere valeur;

    @BeforeEach
    void setUp() {
        valeur = new ValeurBoursiere(
                "GOON",
                "Gooning Corporation of Cégep Limoilou",
                150.0,
                2.5,
                1.7,
                2500000000000.0,
                "Québec",
                1980,
                5000000,
                TypeSecteur.TELECOMMUNICATIONS
        );
    }

    @Test
    void getSymbole() {
        assertEquals("GOON", valeur.getSymbole());
    }

    @Test
    void setSymbole() {
        valeur.setSymbole("CEGEP");
        assertEquals("CEGEP", valeur.getSymbole());
    }

    @Test
    void getNom() {
        assertEquals("Gooning Corporation of Cégep Limoilou", valeur.getNom());
    }

    @Test
    void setNom() {
        valeur.setNom("Dollorascrap");
        assertEquals("Dollorascrap", valeur.getNom());
    }

    @Test
    void getDerniereVente() {
        assertEquals(150.0, valeur.getDerniereVente());
    }

    @Test
    void setDerniereVente() {
        valeur.setDerniereVente(200.0);
        assertEquals(200.0, valeur.getDerniereVente());
    }

    @Test
    void getChangementNet() {
        assertEquals(2.5, valeur.getChangementNet());
    }

    @Test
    void setChangementNet() {
        valeur.setChangementNet(-1.2);
        assertEquals(-1.2, valeur.getChangementNet());
    }

    @Test
    void getPourcentageChangement() {
        assertEquals(1.7, valeur.getPourcentageChangement());
    }

    @Test
    void setPourcentageChangement() {
        valeur.setPourcentageChangement(-0.5);
        assertEquals(-0.5, valeur.getPourcentageChangement());
    }

    @Test
    void getCapitalisationBoursiere() {
        assertEquals(2500000000000.0, valeur.getCapitalisationBoursiere());
    }

    @Test
    void setCapitalisationBoursiere() {
        valeur.setCapitalisationBoursiere(1800000000000.0);
        assertEquals(1800000000000.0, valeur.getCapitalisationBoursiere());
    }

    @Test
    void getPays() {
        assertEquals("Québec", valeur.getPays());
    }

    @Test
    void setPays() {
        valeur.setPays("Canada");
        assertEquals("Canada", valeur.getPays());
    }

    @Test
    void getAnneeEntreeEnMarche() {
        assertEquals(1980, valeur.getAnneeEntreeEnMarche());
    }

    @Test
    void setAnneeEntreeEnMarche() {
        valeur.setAnneeEntreeEnMarche(2004);
        assertEquals(2004, valeur.getAnneeEntreeEnMarche());
    }

    @Test
    void getVolume() {
        assertEquals(5000000, valeur.getVolume());
    }

    @Test
    void setVolume() {
        valeur.setVolume(10000000);
        assertEquals(10000000, valeur.getVolume());
    }

    @Test
    void getSecteur() {
        assertEquals(TypeSecteur.TELECOMMUNICATIONS, valeur.getSecteur());
    }

    @Test
    void setSecteur() {
        valeur.setSecteur(TypeSecteur.INDUSTRIEL);
        assertEquals(TypeSecteur.INDUSTRIEL, valeur.getSecteur());
    }

    @Test
    void validerSymbole() {
        assertDoesNotThrow(() -> valeur.validerSymbole("TSLA"));
        assertThrows(IllegalArgumentException.class, () -> valeur.validerSymbole("TESLAAA"));
    }

    @Test
    void validerDerniereVente() {
        assertDoesNotThrow(() -> valeur.validerDerniereVente(100.0));
        assertThrows(IllegalArgumentException.class, () -> valeur.validerDerniereVente(0.0));
        assertThrows(IllegalArgumentException.class, () -> valeur.validerDerniereVente(-5.0));
    }

    @Test
    void testToString() {
        String attendu = "ValeurBoursiere{symbole='GOON', nom='Gooning Corporation of Cégep Limoilou', derniereVente=150.0, changementNet=2.5, pourcentageChangement=1.7, capitalisationBoursiere=2.5E12, pays='Québec', anneeEntreeEnMarche=1980, volume=5000000, secteur=TELECOMMUNICATIONS'}";
        assertEquals(attendu, valeur.toString());
    }
}
