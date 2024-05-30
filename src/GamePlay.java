import java.util.Random;
import java.util.Scanner;
public interface GamePlay {

    static void Jeu(WordList l){

        String choice = "y";
        Scanner in = new Scanner(System.in);

        while (choice.equals("y")) {
            Random rand = new Random();
            Game g = new Game();
            int index = rand.nextInt(l.getDictionnaire().size());
            System.out.println("En commance");
            System.out.println("-------------------------------------");
            System.out.println("Donner le nombre d'essais : ");

            int essais = in.nextInt();

            if (essais <= 0) {
                break;
            }

            g.setNbEssais(essais);
            g.setMotCache(l.getDictionnaire().get(index));
            Game.setNbEssaisRestants(essais);


            while (Game.getNbEssaisRestants() > 0) {

                if (!g.getMotTrouve().contains("*")) {
                    System.out.println("Game Over!");
                    Game.setNbPartPerdues(Game.getNbPartPerdues() + 1);
                    break;

                }

                System.out.println("Votre nombre d'essais : " + Game.getNbEssaisRestants());
                System.out.println("Le mot trouvé est : " + g.getMotTrouve());
                System.out.println("Donner un mot : ");

                String m = in.next();

                if (g.testMot(m)) {

                    if (m.toUpperCase().equals(g.getMotCache())) {
                        System.out.println("Gagné!");

                        Game.setNbPartGagnees(Game.getNbPartGagnees() + 1);
                        break;

                    } else {
                        Game.setNbEssaisRestants(Game.getNbEssaisRestants() - 1);
                        if (Game.getNbEssaisRestants() == 0) {
                            Game.setNbPartPerdues(Game.getNbPartPerdues() + 1);
                        }
                    }
                } else {
                    Game.setNbEssaisRestants(Game.getNbEssaisRestants() - 1);
                    if (Game.getNbEssaisRestants() == 0) {
                        Game.setNbPartPerdues(Game.getNbPartPerdues() + 1);
                    }
                }
            }

            if (Game.getNbEssaisRestants() == 0) {
                System.out.println("Game Over!");
            }

            System.out.println("Une autre partie? y/n");
            choice = in.next();
            System.out.println("-------------------------------------");

        }


        System.out.println(Game.getNbPartGagnees() + " Parties gagné!");
        System.out.println(Game.getNbPartPerdues() + " Parties perdu!");
        in.close();

    }
}
