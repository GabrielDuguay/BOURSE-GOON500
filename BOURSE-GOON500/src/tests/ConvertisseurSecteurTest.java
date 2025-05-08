package tests;

import bourse.ConvertisseurSecteur;
import bourse.TypeSecteur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertisseurSecteurTest {

    @Test
    void convertir_valeurConnue_retourneEnumCorrect() {
        ConvertisseurSecteur convertisseur = new ConvertisseurSecteur();

        assertEquals(TypeSecteur.TECHNOLOGIE, convertisseur.convertir("Technology"));
        assertEquals(TypeSecteur.SANTE, convertisseur.convertir("Health Care"));
        assertEquals(TypeSecteur.FINANCE, convertisseur.convertir("Finance"));
        assertEquals(TypeSecteur.CONSOMMATION_DISCRETIONNAIRE, convertisseur.convertir("Consumer Discretionary"));
        assertEquals(TypeSecteur.CONSOMMATION_DE_BASE, convertisseur.convertir("Consumer Staples"));
        assertEquals(TypeSecteur.ENERGIE, convertisseur.convertir("Energy"));
        assertEquals(TypeSecteur.INDUSTRIEL, convertisseur.convertir("Industrials"));
        assertEquals(TypeSecteur.MATERIAUX, convertisseur.convertir("Basic Materials"));
        assertEquals(TypeSecteur.TELECOMMUNICATIONS, convertisseur.convertir("Telecommunications"));
        assertEquals(TypeSecteur.UTILITES, convertisseur.convertir("Utilities"));
        assertEquals(TypeSecteur.IMMOBILIER, convertisseur.convertir("Real Estate"));
    }

    @Test
    void convertir_valeurInconnue_retourneNull() {
        ConvertisseurSecteur convertisseur = new ConvertisseurSecteur();

        assertNull(convertisseur.convertir("Unknown Sector"));
        assertNull(convertisseur.convertir("Tech"));  // valeur partielle
        assertNull(convertisseur.convertir(""));      // chaîne vide
        assertNull(convertisseur.convertir(null));    // null
    }
}
