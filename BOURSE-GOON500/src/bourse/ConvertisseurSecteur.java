package bourse;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe utilitaire servant à convertir des noms de secteurs (issus d’un fichier CSV)
 * en constantes de l’énumération {@link TypeSecteur}.
 * <p>
 * Cette classe contient une map interne qui fait le lien entre les noms en anglais
 * (tels qu'on les retrouve dans les données d'entrée) et les valeurs de l'enum {@link TypeSecteur}.
 * </p>
 *
 * Exemple : "Health Care" &rarr; {@code TypeSecteur.SANTE}
 *
 * @author ChatGPT (OpenAI)
 */
public class ConvertisseurSecteur {

    /**
     * Dictionnaire qui associe les noms textuels des secteurs à leurs équivalents dans l'énumération {@link TypeSecteur}.
     */
    private final Map<String, TypeSecteur> mapping;

    /**
     * Constructeur. Initialise la map avec les correspondances fixes entre chaînes CSV et {@link TypeSecteur}.
     * Cette méthode a été en partie travaillé avec ChatGPT
     */
    public ConvertisseurSecteur() {
        mapping = new HashMap<>();
        mapping.put("Technology", TypeSecteur.TECHNOLOGIE);
        mapping.put("Health Care", TypeSecteur.SANTE);
        mapping.put("Finance", TypeSecteur.FINANCE);
        mapping.put("Consumer Discretionary", TypeSecteur.CONSOMMATION_DISCRETIONNAIRE);
        mapping.put("Consumer Staples", TypeSecteur.CONSOMMATION_DE_BASE);
        mapping.put("Energy", TypeSecteur.ENERGIE);
        mapping.put("Industrials", TypeSecteur.INDUSTRIEL);
        mapping.put("Basic Materials", TypeSecteur.MATERIAUX);
        mapping.put("Telecommunications", TypeSecteur.TELECOMMUNICATIONS);
        mapping.put("Utilities", TypeSecteur.UTILITES);
        mapping.put("Real Estate", TypeSecteur.IMMOBILIER);
    }

    /**
     * Convertit une chaîne représentant un secteur (provenant du CSV) en valeur de l'énumération {@link TypeSecteur}.
     *
     * @param secteurTexte Le nom du secteur tel qu'écrit dans le fichier source (ex. "Finance").
     * @return Le {@link TypeSecteur} correspondant, ou {@code null} si non reconnu.
     */
    public TypeSecteur convertir(String secteurTexte) {
        return mapping.getOrDefault(secteurTexte, null);
    }
}
