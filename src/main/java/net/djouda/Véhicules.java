package net.djouda;

import java.util.List;

public class Véhicules implements Démarrable {

    private String marque;
    private String modele;
    private Moteur moteur;
    private final List<Roue> roues;
    private int vitesse;

    public Véhicules(String marque, String modele, Moteur moteur, List<Roue> roues) {
        if (marque == null || marque.isBlank()) {
            throw new IllegalArgumentException("La marque est obligatoire.");
        }
        if (moteur == null) {
            throw new IllegalArgumentException("Un véhicule doit avoir un moteur.");
        }
        if (roues == null || roues.isEmpty()) {
            throw new IllegalArgumentException("Un véhicule doit avoir des roues.");
        }
        this.marque = marque;
        this.modele = modele;
        this.moteur = moteur;
        this.roues = List.copyOf(roues); // copie défensive : personne ne modifie nos roues de l'extérieur
        this.vitesse = 0;
    }

    @Override
    public void demarrer() {
        moteur.demarrer();              // ← DÉLÉGATION : le véhicule ne démarre pas, son moteur le fait
        System.out.println("Le véhicule " + marque + " " + modele + " démarre pres a rouler sur " + roues.size() + " roues.");
    }

    @Override
    public void arreter() {
        this.vitesse = 0;
        moteur.arreter();
        System.out.println("Le véhicule " + marque + " " + modele + " s'arrête.");
    }

    @Override
    public boolean estEnMarche() {
        return moteur.estEnMarche();
    }

    public void accelerer(int delta) {
        if (!moteur.estEnMarche()) {
            System.out.println("Impossible d'accélérer : le moteur est arrêté.");
            return;
        }
        if (delta <= 0) {
            System.out.println("L'accélération doit être positive.");
            return;
        }
        this.vitesse += delta;
        System.out.println("→ Accélération de " + delta + " km/h.");
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public int getNombreRoues() {
        return roues.size();
    }

    public int getVitesse() {
        return vitesse;
    }

    @Override
    public String toString() {
        return marque + " " + modele
                + " | moteur : " + moteur
                + " | " + roues.size() + " roues"
                + " | vitesse : " + vitesse + " km/h";
    }
}


