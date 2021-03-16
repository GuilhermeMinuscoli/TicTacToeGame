package Application;

import java.util.Scanner;

public class Principal {

	static int resposta;
	static boolean jogadorXganhou = false;
	static boolean jogadorOganhou = false;
	static JogoDaVelha jogo;

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		
		System.out.println("O primeiro jogador joga com X, o segundo com O");

		System.out.println("Digite o nome do jogador 1:");
		String name1 = sc.nextLine();
		System.out.println("Digite o nome do jogador 2:");
		String name2 = sc.nextLine();
		System.out.println("Digite a dimensão do tabuleiro: ");
		int dimension = sc.nextInt();

		Jogador jogador1 = new Jogador(name1);
		Jogador jogador2 = new Jogador(name2);

		jogo = new JogoDaVelha(dimension);

		do {
			jogadorXganhou = false;
			jogadorOganhou = false;
			
			do {
				System.out.println("Jogador 1 escolha a linha e a coluna");

				showActualGame();

				int linha1 = sc.nextInt();
				int coluna1 = sc.nextInt();
				char jogada1 = sc.next().charAt(0);

				jogo.realizaJogada(linha1, coluna1, jogada1);

				linha1 = 0;
				coluna1 = 0;
				jogada1 = 0;

				jogadorXganhou = jogo.verificaGanhadorX();
				
				if(jogadorXganhou == true) {
					break;
				}
				
				showActualGame();

				System.out.println("Jogador 2 escolha a linha e a coluna");
				int linha2 = sc.nextInt();
				int coluna2 = sc.nextInt();
				char jogada2 = sc.next().charAt(0);

				jogo.realizaJogada(linha2, coluna2, jogada2);
				linha2 = 0;
				coluna2 = 0;
				jogada2 = 0;

				jogadorOganhou = jogo.verificaGanhadorO();

				showActualGame();

			} while (jogadorXganhou == false || jogadorOganhou == false);

			if (jogadorXganhou == true) {
				System.out.println("Jogador 1 ganhou!");
				System.out.println("Adicione 1 ponto ao jogador");
				jogador1.setPoints(sc.nextInt());
			} else if (jogadorOganhou == true) {
				System.out.println("Jogador 2 ganhou!");
				System.out.println("Adicione 2 ponto ao jogador");
				jogador2.setPoints(sc.nextInt());
			}
			System.out.println();
			System.out.println(jogador1.toString());
			System.out.println(jogador2.toString());
			System.out.println("Deseja jogar novamente?");
			System.out.println("Digite 1 para sim ou 2 para nao");
			resposta = sc.nextInt();

			for (int i = 0; i < jogo.tabuleiro.length; i++) {
				for (int j = 0; j < jogo.tabuleiro.length; j++) {
					jogo.tabuleiro[i][j] = JogoDaVelha.ESPACO_VAZIO;
				}
			}

		} while (resposta != 2);
		sc.close();
	}
	
	public static void showActualGame() {
		System.out.println(jogo.toString());
	}
}
