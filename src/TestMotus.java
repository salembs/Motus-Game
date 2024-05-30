import java.util.Scanner;

public class TestMotus implements GamePlay{
    public static void main(String[] args) {

        if(Integer.parseInt(args[1])>=4 && Integer.parseInt(args[1])<=8) {
            Scanner scanner = new Scanner(new TestMotus().getClass().getClassLoader().getResourceAsStream("d"+Integer.parseInt(args[1])));

            WordList l = new WordList(Integer.parseInt(args[1]), 10);

            l.initialiser(scanner);
            l.tri();

            scanner.close();

            Scanner in = new Scanner(System.in);

            if (args[0].equals("config")) {
                String choice = "";
                while (!choice.equals("q")) {

                    System.out.println("Choisir un caractere : \nr => Recherche\na => Ajout\ns => Supprimer\nf => Afficher\nj => Jouer\nq => Quitter");

                    String choix = in.next();

                    switch (choix) {
                        case "r":
                            System.out.println("Donner le mot : ");
                            l.rechercheMot(in.next());
                            break;
                        case "s":
                            System.out.println("Donner le mot : ");
                            l.supprimeMot(in.next());
                            break;
                        case "a":
                            System.out.println("Donner le mot : ");
                            l.ajoutMot(in.next());
                            break;
                        case "f":
                            l.afficher();
                            break;
                        case "j":
                            GamePlay.Jeu(l);
                            choice = "q";
                            break;

                        case "q":
                            choice = "q";
                            break;
                        default:
                            System.out.println("Choix invalid!");
                            choice = "q";
                    }
                }

            } else if (args[0].equals("jeu") && !l.getDictionnaire().isEmpty()) {

                GamePlay.Jeu(l);

                }

                else {
                scanner.close();
                System.out.println("Redemarer le programme avec des arguments valide!");
            }

            in.close();
        }
        else{
            System.out.println("Redemarer le programme avec des arguments valide!");
        }

    }
}