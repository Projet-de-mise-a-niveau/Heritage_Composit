package net.djouda;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Saisie saisie = new Saisie(scanner);

        System.out.println("=== Configuration d'un véhicule (composition) ===");

        String marque = saisie.lireTexte("Marque : ");
        String modele = saisie.lireTexte("Modèle : ");
        FabriqueVehicule.TypeVehicule type = saisie.lireTypeVehicule();
        Moteur moteur = saisie.lireMoteur();   // ← le moteur est construit tout seul

        Véhicules vehicule = FabriqueVehicule.creer(type, marque, modele, moteur);

        System.out.println("\n=== Véhicule créé ===");
        System.out.println(vehicule);

        System.out.println("\n--- Test de roulage ---");
        vehicule.demarrer();
        vehicule.accelerer(50);
        vehicule.accelerer(30);
        System.out.println("État : " + vehicule);
        vehicule.arreter();
        System.out.println("Après arrêt : " + vehicule);

        scanner.close();
    }
}