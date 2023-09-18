import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyseurDeTexte {

    private List<Observer> observerCollection = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observerCollection.remove(observer);
    }

    public void notifyObservers(String s) {
        for (Observer observer : observerCollection) {
            observer.traiterLigne(s);
        }
    }

    public void readFile(String file) {
        BufferedReader lecteurAvecBuffer = null;
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Erreur d'ouverture");
        }
        String ligne;

        NbLignes nbLignes = new NbLignes();
        NbBelgique nbBelgique = new NbBelgique();
        NbMots nbMots = new NbMots();
        Palindrome nbrPalindromes = new Palindrome();

        while (true) {
            try {
                if (!((ligne = lecteurAvecBuffer.readLine()) != null)) break;
                //nbrLignes++;
                nbLignes.traiterLigne(ligne);
                if (ligne.contains("Belgique")) {
                    //nbrBelgique++;
                    nbBelgique.traiterLigne(ligne);
                }
                for (String mot : ligne.trim().split(" ")) {
                    // nbrMots++;
                    nbMots.traiterLigne(ligne);
                    StringBuffer temp = new StringBuffer(mot);
                    if (mot.equals(temp.reverse().toString())) {
                        //nbrPalindromes++;
                        nbrPalindromes.traiterLigne(ligne);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

//SHERA LA PLUS MOCHE T MOCHE T MOCHE NNNANANANANNANAAAAAAAAAAAAAAAAAAAAAAA
//OOUUUUUUUUUUH LA THEIERE A LA BOITE DE PANDORE QUI LUI SERT DE BOUUUUCHEUH
