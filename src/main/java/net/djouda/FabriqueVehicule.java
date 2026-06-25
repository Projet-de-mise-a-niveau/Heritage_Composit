package net.djouda;

import java.util.ArrayList;
import java.util.List;

public class FabriqueVehicule {
    public enum TypeVehicule {
        VOITURE(4, 17),
        MOTO(2, 17),
        CAMION(6, 22);

        final int nombreRoues;
        final int diametre;

        TypeVehicule(int nombreRoues, int diametre) {
            this.nombreRoues = nombreRoues;
            this.diametre = diametre;
        }
    }

    private FabriqueVehicule() {}

    private static List<Roue> creerRoues(int nombre, int diametre) {
        List<Roue> roues = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            boolean motrice = (i >= nombre - 2); // les 2 dernières sont motrices, par exemple
            roues.add(new Roue(diametre, motrice));
        }
        return roues;
    }

    public static Véhicules creer(TypeVehicule type, String marque, String modele, Moteur moteur) {
        return new Véhicules(marque, modele, moteur,
                creerRoues(type.nombreRoues, type.diametre));
    }
}
