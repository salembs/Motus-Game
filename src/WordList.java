import java.util.ArrayList;
import java.util.Scanner;
public class WordList{

    private static int tailleMot = 0;
    private int nbMots;
    private ArrayList<String> dictionnaire;

    // constructors

    public WordList(int tailleMot, int nbMots) {
        WordList.tailleMot = tailleMot;
        this.nbMots = nbMots;
        this.dictionnaire = new ArrayList<>();
    }

    //setters and getters

    public static int getTailleMot() {
        return tailleMot;
    }
    public static void setTailleMot(int tailleMot) {
        WordList.tailleMot = tailleMot;
    }
    public int getNbMots() {
        return nbMots;
    }
    public void setNbMots(int nbMots) {
        this.nbMots = nbMots;
    }
    public ArrayList<String> getDictionnaire() {
        return dictionnaire;
    }
    public void setDictionnaire(ArrayList<String> dictionnaire) {
        this.dictionnaire = dictionnaire;
    }

    // methods

    public void initialiser(Scanner sc){
        while(sc.hasNext()){
            dictionnaire.add(sc.next());
        }
    }

    public void rechercheMot(String mot) {
        if(dictionnaire.contains(mot)){
            System.out.println("le mot => : " + mot + " existe");
        }
        else{
            System.out.println("le mot => : " + mot + " n'existe pas");
        }
    }

    public void ajoutMot(String mot)
    {
        boolean valid = true;
        if(!dictionnaire.contains(mot) && mot.length() == tailleMot) {

                for(int j = 0; j < mot.length(); j++) {

                    if( !Character.isAlphabetic(mot.charAt(j)) || Character.isLowerCase(mot.charAt(j))) {
                        valid = false;
                        break;
                    }

                }
        }
        else {
            valid = false;
        }

        if(valid) {
            dictionnaire.add(mot);
            nbMots++;
            tri();
        }
        else {
            System.out.println("On ne peut pas ajouter ce mot => " + mot);
        }

    }

    public void supprimeMot(String mot) {

        if(!dictionnaire.remove(mot)) {
            System.out.println("mot n'existe pas!");
        }
        else {
            nbMots--;
            System.out.println("supprimé => " + mot);
        }
    }

    public void tri() {
        int n = dictionnaire.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dictionnaire.get(j).compareTo(dictionnaire.get(j + 1)) > 0) {
                    String aux = dictionnaire.get(j);
                    dictionnaire.set(j, dictionnaire.get(j + 1));
                    dictionnaire.set(j + 1, aux);
                }
            }
        }
    }

    public void afficher() {
        System.out.println("-------------------------------------");

        for(String i : dictionnaire) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------");

    }

}
