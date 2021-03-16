package Application;

public class Jogador {
	private String name;
	private int points;
	
	public Jogador(String name) {
		this.name = name;
		points = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Nome do jogador: " + name + ", points = " + points;
	}
	
}
