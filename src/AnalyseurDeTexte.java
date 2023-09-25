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

    public void endObservers() {
        for (Observer observer : observerCollection) {
            observer.finFichier();
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

        try {
            while ((ligne = lecteurAvecBuffer.readLine()) != null) {
                for (Observer observer : observerCollection) {
                    observer.traiterLigne(ligne);
                }

            }
            for (Observer o:observerCollection){
                o.finFichier();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
