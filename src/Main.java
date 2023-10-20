import oo.java.Jogo;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("____________Desafio do numero secreto____________ ");

        while (true) {
            try {

                Jogo sorte = new Jogo();
                sorte.setTentativas(20);


                while (sorte.getQualFase() <= 4) {
                    sorte.sorteando();
                    if (sorte.getTentativas() == 0) {
                        System.out.println("Voce perdeu! deseja recomeçar?   S/N");
                        String recomeco = scanner.nextLine();

                        if (recomeco.equalsIgnoreCase("S")) {
                            System.out.println("Ok! RESETANDO....");
                            break;
                        } else if (recomeco.equalsIgnoreCase("n")) {
                            System.out.println("Obrigado por jogar!");
                            System.exit(0);
                        }

                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por gentileza, digite apenas numeros!  ");
            }
        }

    }

}