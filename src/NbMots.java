public class NbMots implements Observer{
    private int cpt = 0;
    @Override
    public void traiterLigne(String s) {
        for (String mot : s.trim().split(" ")) {
            cpt++;
        }
    }

    @Override
    public void finFichier() {
        System.out.println("Il y avait " + cpt + " mots.");
    }
}
