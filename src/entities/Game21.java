package entities;

import java.util.Random;
import java.util.Scanner;

public record Game21(Player player1, Player player2) {
	
	// Método que agrupa toda a lógica do jogo
	public void startGame () {
		// Gere uma rodada nova enquanto um ou dois players estiverem no jogo (inGame = true) e enquanto ambos estiverem com o score abaixo de 21
		while ((player1.getInGame() == true || player2.getInGame() == true) && (player1.getScore() < 21 && player2.getScore() < 21)) {
			
			System.out.println("\t" + player1.getName() + " " + player1.getScore() + " X " + player2.getScore() + " " + player2.getName() + "\n");
			player1.incrementScore(player1Move());
			player2.incrementScore(player2Move());
		}
	}
	
	// Exibe o campeão do jogo
	public void gameWinner () {
		String gameWinner;
		if (player1.getScore() == player2.getScore()) gameWinner = "EMPATE!";
		else if ((21 - player1.getScore() < 21 - player2.getScore()) || (player2.getScore() > 21)) gameWinner = player1.getName();
		else gameWinner = player2.getName();
		
		System.out.println("\n********* FIM DO JOGO *********\n\tCAMPEÃO = " + gameWinner + "\n*******************************");
	}
	
	// Jogada do player 1
	private int player1Move () {
		try {
			checkPlayerInGame(player1); // Se inGame = false, o player não joga
			Random randomLetter = new Random(); // Gera o número aleatório da carta puxada
			Scanner sc = new Scanner (System.in);
			
			System.out.print(player1.getName() + ", DESEJA PUXAR UMA CARTA? (SIM/NÃO) ");
			char answer = Character.toLowerCase(sc.next().charAt(0));
			
			return checkAnswer(player1, answer, randomLetter);
		} catch (RuntimeException e) {
			return 0;
		}
	}
	
	// Jogada do player 2
	private int player2Move () {
		try {
			checkPlayerInGame(player2); // Se inGame = false, o player não joga
			Random randomLetter = new Random(); // Retorna um número aleatório de 1 a 13
			Scanner sc = new Scanner (System.in);
			
			System.out.print(player2.getName() + ", DESEJA PUXAR UMA CARTA? (SIM/NÃO)");
			char answer = sc.next().charAt(0);
			
			return checkAnswer(player2, answer, randomLetter);
		} catch (RuntimeException e) {
			return 0;
		}
	}
	
	// Checa se o player continua ou não no jogo
	private void checkPlayerInGame (Player player) {
		if (player.getInGame() == false) throw new IllegalArgumentException();
	}
	
	// checa e da um retorno baseado na resposta do player e em regras de negócio
	private int checkAnswer (Player player, char answer, Random randomLetter) {
		if (answer == 's') {
			return randomLetter.nextInt(1, 14); // Retorna um número aleatório de 1 a 13
		}
		else if (answer == 'n') {
			player.setInGame(false); // Player optou por parar e está fora do jogo (inGame = false)
			return 0;
		}
		else {
			System.out.println("ENTRADA ILEGAL. VOCÊ ESTÁ FORA DO JOGO!");
			player.setInGame(false);
			return 0;
		}
	}
	
}

