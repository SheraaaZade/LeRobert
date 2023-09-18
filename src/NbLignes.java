public class NbLignes implements Observer{
    private int cpt = 0;
    @Override
    public void traiterLigne(String s) {
        cpt++;
    }
}
