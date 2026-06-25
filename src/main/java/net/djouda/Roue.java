package net.djouda;

public class Roue {


    private final int diametrePouces;
    private final boolean motrice; // une roue motrice transmet la puissance

    public Roue(int diametrePouces, boolean motrice) {
        if (diametrePouces <= 0) {
            throw new IllegalArgumentException("Le diamètre doit être positif.");
        }
        this.diametrePouces = diametrePouces;
        this.motrice = motrice;
    }

    public int getDiametrePouces() { return diametrePouces; }
    public boolean estMotrice()    { return motrice; }

    @Override
    public String toString() {
        return diametrePouces + "\" " + (motrice ? "(motrice)" : "(libre)");
    }
}
