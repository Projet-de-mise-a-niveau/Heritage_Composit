package net.djouda;

// Saisie.java

import java.util.Scanner;

public class Saisie {

    private final Scanner scanner;

    public Saisie(Scanner scanner) {
        this.scanner = scanner;
    }

    // --- briques génériques de lecture robuste ---

    public String lireTexte(String invite) {
        String valeur;
        do {
            System.out.print(invite);
            valeur = scanner.nextLine().trim();
            if (valeur.isEmpty()) {
                System.out.println("  ⚠ La saisie ne peut pas être vide.");
            }
        } while (valeur.isEmpty());
        return valeur;
    }

    public int lireEntierPositif(String invite) {
        while (true) {
            System.out.print(invite);
            String ligne = scanner.nextLine().trim();
            try {
                int valeur = Integer.parseInt(ligne);
                if (valeur <= 0) {
                    System.out.println("  ⚠ Le nombre doit être strictement positif.");
                    continue;
                }
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("  ⚠ Entrée invalide : tapez un nombre entier.");
            }
        }
    }

    // --- lecture INDÉPENDANTE de chaque composant ---

    /**
     * Lit et construit un Moteur, sans rien savoir du reste.
     */
    public Moteur lireMoteur() {
        System.out.println("\n--- Configuration du MOTEUR ---");
        Moteur.Type type = lireEnum(
                "Motorisation (ESSENCE/DIESEL/ELECTRIQUE) : ",
                Moteur.Type.class);
        int puissance = lireEntierPositif("Puissance (cv) : ");
        return new Moteur(type, puissance);
    }

    /**
     * Lit le type de véhicule, sans rien savoir du moteur.
     */
    public FabriqueVehicule.TypeVehicule lireTypeVehicule() {
        System.out.println("\n--- Type de VÉHICULE ---");
        return lireEnum(
                "Type (VOITURE/MOTO/CAMION) : ",
                FabriqueVehicule.TypeVehicule.class);
    }

    /**
     * Outil générique : lit n'importe quel enum de façon sûre.
     */
    private <E extends Enum<E>> E lireEnum(String invite, Class<E> classeEnum) {
        while (true) {
            System.out.print(invite);
            String ligne = scanner.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf(classeEnum, ligne);
            } catch (IllegalArgumentException e) {
                System.out.print("  ⚠ Choix invalide. Options : ");
                for (E valeur : classeEnum.getEnumConstants()) {
                    System.out.print(valeur + " ");
                }
                System.out.println();
            }
        }
    }
}
