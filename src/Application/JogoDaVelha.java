package Application;

import java.util.Arrays;

public class JogoDaVelha {

	static final char JOGADA_X = 'X';
	static final char JOGADA_O = 'O';
	char[][] tabuleiro;
	int dimensaoTabuleiro;
	static final char ESPACO_VAZIO = '*';

	public JogoDaVelha(int dimensoes) {

		this.tabuleiro = new char[dimensoes][dimensoes];
		dimensaoTabuleiro = dimensoes;

		clearTable();
	}

	@Override
	public String toString() {

		String print = "";

		for (int i = 0; i < tabuleiro.length; i++) {

			print += "\n ";

			for (int j = 0; j < tabuleiro.length; j++) {

				print += tabuleiro[i][j];
				if (j != tabuleiro.length - 1) {
					print += " | ";
				}
			}

			print += "\n";

			if (i != tabuleiro.length * 4 - 1) {

				for (int j = 0; j < tabuleiro.length * 4; j++) {
					print += "_";
				}

				print += "\n";
			}
		}

		return print;
	}
	
	public void clearTable() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = ESPACO_VAZIO;
			}
		}
	}

	public boolean realizaJogada(int linha, int coluna, char jogada) {

		if (linha > dimensaoTabuleiro || coluna > dimensaoTabuleiro) {
			
			return false;
		}

		if (linha < 0 || coluna < 0) {
			
			return false;
		}

		if (jogada != JOGADA_X && jogada != JOGADA_O) {
			
			return false;
		}

		if (tabuleiro[linha][coluna] != ESPACO_VAZIO) {
			return false;
		}

		tabuleiro[linha][coluna] = jogada;

		return true;
	}

	public boolean verificaGanhadorX() {

		boolean resultadoDiagonalPrincipalJogadorX = false;
		resultadoDiagonalPrincipalJogadorX = verificaGanhadorDiagonal(JOGADA_X);

		boolean resultadoDiagonalSecundariaJogadorX = false;
		resultadoDiagonalSecundariaJogadorX = verificaGanhadorDiagonalSecundariaX(JOGADA_X);

		boolean resultadoLinhaJogadorX = false;
		resultadoLinhaJogadorX = verificaGanhadorLinhaX(JOGADA_X);

		boolean resultadoColunaJogadorX = false;
		resultadoColunaJogadorX = verificaGanhadorColunaX(JOGADA_X);

		return resultadoDiagonalPrincipalJogadorX || resultadoDiagonalSecundariaJogadorX || resultadoLinhaJogadorX
				|| resultadoColunaJogadorX;
	}

	public boolean verificaGanhadorO() {
		boolean resultadoDiagonalPrincipalJogadorO = false;
		resultadoDiagonalPrincipalJogadorO = verificaGanhadorDiagonal(JOGADA_O);

		boolean resultadoDiagonalSecundariaJogadorO = false;
		resultadoDiagonalSecundariaJogadorO = verificaGanhadorDiagonalSecundariaO(JOGADA_O);

		boolean resultadoLinhaJogadorO = false;
		resultadoLinhaJogadorO = verificaGanhadorLinhaO(JOGADA_O);

		boolean resultadoColunaJogadorO = false;
		resultadoColunaJogadorO = verificaGanhadorColunaO(JOGADA_O);

		return resultadoDiagonalPrincipalJogadorO || resultadoDiagonalSecundariaJogadorO || resultadoLinhaJogadorO
				|| resultadoColunaJogadorO;
	}

	private boolean verificaGanhadorDiagonal(char jogada) {
		int countDiag = 0;
		for (int i = 0; i < tabuleiro.length; i++) {

			if (tabuleiro[i][i] == jogada) {
				countDiag += 1;
				if (countDiag == tabuleiro.length) {
					countDiag = 0;
					return true;
				}
			}
		}

		return false;
	}

	private boolean verificaGanhadorDiagonalSecundariaX(char jogada) {
		int countDiagSecX = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][tabuleiro.length - (i + 1)] == JOGADA_X) {
				countDiagSecX += 1;
				if (countDiagSecX == tabuleiro.length) {
					countDiagSecX = 0;
					return true;
				}
			}

		}
		return false;

	}

	private boolean verificaGanhadorDiagonalSecundariaO(char jogada) {
		int countDiagSecO = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][tabuleiro.length - (i + 1)] == JOGADA_O) {
				countDiagSecO += 1;
				if (countDiagSecO == tabuleiro.length) {
					countDiagSecO = 0;
					return true;
				}
			}

		}
		return false;

	}

	private boolean verificaGanhadorLinhaX(char jogada) {
		int countLinhaX = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[i][j] == JOGADA_X) {
					countLinhaX += 1;
					if (countLinhaX == tabuleiro.length) {
						countLinhaX = 0;
						return true;
					}
				}
			}
		}
		return false;

	}

	private boolean verificaGanhadorLinhaO(char jogada) {
		int countLinhaO = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[i][j] == JOGADA_O) {
					countLinhaO += 1;
					if (countLinhaO == tabuleiro.length) {
						countLinhaO = 0;
						return true;
					}
				}
			}
		}
		return false;

	}

	private boolean verificaGanhadorColunaX(char jogada) {
		int countColunaX = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[j][i] == JOGADA_X) {
					countColunaX += 1;
					if (countColunaX == tabuleiro.length) {
						countColunaX = 0;
						return true;
					}
				}
			}
		}
		return false;

	}
	
	private boolean verificaGanhadorColunaO(char jogada) {
		int countColunaO = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[j][i] == JOGADA_O) {
					countColunaO += 1;
					if (countColunaO == tabuleiro.length) {
						countColunaO = 0;
						return true;
					}
				}
			}
		}
		return false;

	}
}
