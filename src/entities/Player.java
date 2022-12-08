package entities;

public class Player {
	private String name;
	private Integer score;
	
	// Construtores da classe
	
	public Player () {
	}
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
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
	
	// Métodos da classe
	
	public void incrementScore (int addScore) {
		this.score += addScore; // Acumulador de score do player
	}
	
}
