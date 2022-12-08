package application;

import java.util.Scanner;

import entities.Game21;
import entities.Player;

public class Program {
	
	// Criar partida e jogador
	public static Game21 gameOpening () {
		Scanner sc = new Scanner (System.in);
		System.out.println("********* Baralho: Modalidade 21 - WELCOME! *********\n");
		
		System.out.println("REGRAS DO JOGO: \n1º Acumule pontos puxando uma carta aleatória até chegar em 21"
										 + "\n2º Vence quem chegar mais próximo de 21 ou em 21"
										 + "\n3º Perderá a partida quem passar de 21"
										 + "\n4º Não poderá puxar mais cartas caso opte por parar"
										 + "\n5º Perderá o direito de jogar caso digite uma opção fora de contexto\n");

		System.out.print("Informe o nome do jogador 1: ");
		Player player1 = new Player(sc.next().toUpperCase());
		
		System.out.print("Informe o nome do jogador 2: ");
		Player player2 = new Player(sc.next().toUpperCase());
		
		System.out.println();
		
		return new Game21(player1, player2);
	}

	public static void main(String[] args) {
		Game21 game = gameOpening();
		game.startGame();
		game.gameWinner();
	}

}
