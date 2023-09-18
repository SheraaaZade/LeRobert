public class Palindrome implements Observer{
    private int cpt = 0;
    @Override
    public void traiterLigne(String s) {
        for (String mot : s.trim().split(" ")) {
            StringBuffer temp = new StringBuffer(mot);
            if (mot.equals(temp.reverse().toString())) {
                cpt++;
            }
        }
    }
}
