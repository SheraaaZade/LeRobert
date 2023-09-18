public class NbLignes implements Observer{
    private int cpt = 0;
    @Override
    public void traiterLigne(String s) {
        cpt++;
    }

    @Override
    public void traiterLigne() {
        System.out.println("Il y avait " + cpt + " lignes.");
    }
}
