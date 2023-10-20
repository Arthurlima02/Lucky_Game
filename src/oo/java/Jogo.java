package oo.java;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Jogo {
    //instanciando
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    //Declarando variaveis
    protected int numeroSorteado = random.nextInt(100);
    protected int tentativas;

    public boolean continuar = true;

    protected int qualFase = 1;

    //Getters

    public int getQualFase() {
        return qualFase;
    }


    public int getTentativas() {
        return tentativas;
    }

    //setters


    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }


    public void sorteando() {
        while (continuar && qualFase <= 4) {

            if (qualFase <= 3) {
                System.out.println("Digite um numero de 0 a 100");
                System.out.println(numeroSorteado);

            } else if (qualFase == 4) {
                System.out.println("Digte um numero de 0 a 10");
                System.out.println(numeroSorteado);
            }

            try {
                int numeroUsuario = scanner.nextInt();

                if (numeroUsuario > 100 && qualFase <=3) {
                    System.out.println("O número não pode ser MAIOR 100!");
                    break;
                } else if (numeroUsuario > 10 && qualFase == 4){
                    System.out.println("O numero não pode ser MAIOR que 10");
                    break;
                }else if (numeroUsuario < 0) {
                    System.out.println("O número precisa ser MAIOR que 0!");
                    break;
                }

                if ((qualFase <= 3 && numeroUsuario >= 0 && numeroUsuario <= 100) || (qualFase == 4 && numeroUsuario >= 0 && numeroUsuario <= 10)) {
                    if (numeroSorteado == numeroUsuario) {
                        qualFase++;
                        if (qualFase <= 4) {
                            System.out.println("Parabens, voce acertou! ainda restavam " + --tentativas + " tentativas");
                            System.out.println("Voce deseja avancar para fase " + qualFase + "? S/N");
                            scanner.nextLine();
                            String fase = scanner.nextLine();

                            switch (qualFase) {
                                case 2:
                                    tentativas = 15;
                                    break;
                                case 3:
                                    tentativas = 5;
                                    break;
                                case 4:
                                    tentativas = 1;
                            }

                            boolean avancarFase = true;
                            while (avancarFase) {


                                if (fase.equalsIgnoreCase("s")) {

                                    System.out.println("Parabens, voce subiu para a fase " + qualFase + " E agora tem apenas " + tentativas + " tentativas!");
                                    avancarFase = false;
                                    continuar = true;

                                } else if (fase.equalsIgnoreCase("n")) {
                                    System.out.println("Obrigado por jogar!");
                                    System.exit(0);
                                } else {
                                    System.out.println("Por gentileza, Digite apenas  S ou N!");
                                    avancarFase = false;
                                }

                            }
                        } else if (qualFase == 5) {
                            System.out.println("PARABENS! VOCE GANHOU O JOGO!!!!");
                            System.out.println("Deseja jogar novamente? S/N");
                            scanner.nextLine();
                            String jogarNovamente = scanner.nextLine();

                            if (jogarNovamente.equalsIgnoreCase("S")) {
                                System.out.println("Ok, reiniciando....");
                                break;
                            } else {
                                System.out.println("Parabens pela vitoria, e muito obrigado por jogar!");
                                System.exit(0);
                            }
                        }


                        if (qualFase <= 3) {
                            numeroSorteado = random.nextInt(100);
                        }

                        if (qualFase == 4) {
                            numeroSorteado = random.nextInt(10);
                        }


                    } else if (numeroUsuario > numeroSorteado) {
                        tentativas--;
                        System.out.println("Errou, o numero secreto É MENOR.. Voce ainda tem " + tentativas + " Chances");

                    } else {
                        tentativas--;
                        System.out.println("Errou, o numero secreto É MAIOR... Voce ainda tem " + tentativas + " Chances");

                    }


                    if (tentativas == 0) {
                        System.out.println("Acabou as chances! o numero sorteado foi " + numeroSorteado);
                        continuar = false;

                    }

                }
                }catch(InputMismatchException e){
                System.out.println("Entrada inválida! Digite um número inteiro válido.");
                scanner.next();
            }
        }
    }
}
