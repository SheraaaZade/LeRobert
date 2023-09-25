public class Main {
    public static void main(String[] args) {

        NbLignes nbLignes = new NbLignes();
        NbBelgique nbBelgique = new NbBelgique();
        NbMots nbMots = new NbMots();
        Palindrome nbrPalindromes = new Palindrome();

        AnalyseurDeTexte analyseurDeTexte = new AnalyseurDeTexte();
        analyseurDeTexte.registerObserver(nbLignes);
        analyseurDeTexte.registerObserver(nbBelgique);
        analyseurDeTexte.registerObserver(nbMots);
        analyseurDeTexte.registerObserver(nbrPalindromes);

        analyseurDeTexte.readFile(args[0]);
    }
}
