public class NbBelgique implements Observer{
    private int cpt = 0;
    @Override
    public void traiterLigne(String s) {
        if(s.contains("Belgique")){
            cpt++;
        }
    }
}