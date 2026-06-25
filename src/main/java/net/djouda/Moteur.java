package net.djouda;

public class Moteur implements Démarrable {

    public enum Type {
        ESSENCE,
        DIESEL,
        ELECTRIQUE,
        HYBRIDE
    }

    private final Type type;
    private final int puissanceCv;
    private boolean enMarche;

    public Moteur(Type type, int puissanceCv) {
        if (puissanceCv <= 0) {
            throw new IllegalArgumentException("La puissance doit être supérieure à zéro.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Le type de moteur ne peut pas être nul.");
        }
        this.type = type;
        this.puissanceCv = puissanceCv;
        this.enMarche = false;
    }

    @Override
    public void demarrer() {
        if (enMarche) {
            System.out.println("Le moteur tourne déjà.");
            return;
        }
        this.enMarche = true;
        System.out.println("→ Moteur " + type + " de " + puissanceCv + " cv démarré.");
    }

    @Override
    public void arreter() {
        this.enMarche = false;
        System.out.println("→ Moteur arrêté.");
    }

    @Override
    public boolean estEnMarche() {
        return enMarche;
    }

    public Type getType()       { return type; }
    public int getPuissanceCv() { return puissanceCv; }

    @Override
    public String toString() {
        return type + " (" + puissanceCv + " cv)";
    }
}
