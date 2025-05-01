package bourse;

/**
 * Enumération représentant les différents types de secteurs économiques
 * auxquels une entreprise peut appartenir en bourse.
 * <p>
 * Cette énumération est utilisée pour classifier les valeurs boursières
 * selon leur domaine d'activité principal.
 * </p>
 *
 * <ul>
 *     <li>{@code TECHNOLOGIE} : Technologies de l'information</li>
 *     <li>{@code SANTE} : Produits pharmaceutiques, hôpitaux, biotech</li>
 *     <li>{@code FINANCE} : Banques, assurances, services financiers</li>
 *     <li>{@code CONSOMMATION_DISCRETIONNAIRE} : Biens et services non essentiels (automobiles, loisirs, etc.)</li>
 *     <li>{@code CONSOMMATION_DE_BASE} : Biens de consommation courante (alimentation, produits ménagers)</li>
 *     <li>{@code ENERGIE} : Pétrole, gaz, énergies renouvelables</li>
 *     <li>{@code INDUSTRIEL} : Fabrication, ingénierie, transport</li>
 *     <li>{@code MATERIAUX} : Produits chimiques, métaux, matériaux de construction</li>
 *     <li>{@code TELECOMMUNICATIONS} : Fournisseurs de services téléphoniques et internet</li>
 *     <li>{@code UTILITES} : Électricité, eau, gaz (services publics)</li>
 *     <li>{@code IMMOBILIER} : Développement et gestion immobilière</li>
 * </ul>
 *
 * @author ChatGPT (OpenAI)
 */
public enum TypeSecteur {
    TECHNOLOGIE,
    SANTE,
    FINANCE,
    CONSOMMATION_DISCRETIONNAIRE,
    CONSOMMATION_DE_BASE,
    ENERGIE,
    INDUSTRIEL,
    MATERIAUX,
    TELECOMMUNICATIONS,
    UTILITES,
    IMMOBILIER;
}
