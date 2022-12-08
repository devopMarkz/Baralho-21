package entities;

public class Player {
	private String name;
	private Integer score;
	private Boolean inGame; // Checa se o jogador ainda está no jogo

	// Construtores da classe
	
	public Player () {
	}
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.inGame = true;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}
	
	public Boolean getInGame () {
		return this.inGame;
	}
	
	public void setInGame (boolean resposta) {
		this.inGame = resposta; // Define se o player está ou não no jogo
	}
	
	// Métodos da classe
	
	public void incrementScore (int addScore) {
		this.score += addScore; // Acumulador de score do player
	}
	
}
