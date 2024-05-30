public class Game{

    private int nbEssais;
    private static int nbEssaisRestants = 0;
    private static int nbPartGagnees = 0;
    private static int nbPartPerdues = 0;
    private String motCache ;
    private String motTrouve ;

    // constructor
    public Game(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < WordList.getTailleMot(); i++){
            s.append("*");
        }
        this.motTrouve = s.toString();
    }

    // setters and getters
    public int getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }

    public static int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public static void setNbEssaisRestants(int nbEssaisRestants) {
        Game.nbEssaisRestants = nbEssaisRestants;
    }

    public static int getNbPartGagnees() {
        return nbPartGagnees;
    }

    public static void setNbPartGagnees(int nbPartGagnees) {
        Game.nbPartGagnees = nbPartGagnees;
    }

    public static int getNbPartPerdues() {
        return nbPartPerdues;
    }

    public static void setNbPartPerdues(int nbPartPerdues) {
        Game.nbPartPerdues = nbPartPerdues;
    }

    public String getMotCache() {
        return motCache;
    }

    public void setMotCache(String motCache) {
        this.motCache = motCache;
    }

    public String getMotTrouve() {
        return motTrouve;
    }

    public void setMotTrouve(String motTrouve) {
        this.motTrouve = motTrouve;
    }


    // methods

    public void comparer(String mot){

            for(int i = 0; i < mot.length(); i++){
                if(motCache.charAt(i) == mot.charAt(i)){
                    this.motTrouve = motTrouve.substring(0, i) + mot.charAt(i) + motTrouve.substring(i+1);
                }
            }
    }

    public boolean testMot(String mot){

        boolean valid = true;

        if (mot.length() == WordList.getTailleMot()){
            for(int j = 0; j < mot.length(); j++) {

                if(!Character.isAlphabetic(mot.charAt(j))) {
                    valid = false;
                    break;
                }

            }

            if(valid){this.comparer(mot.toUpperCase());}

        }
        else{
            valid = false;
            System.out.println("mot invalid!");
        }

        return valid;

    }

}