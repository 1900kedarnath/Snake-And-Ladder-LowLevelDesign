package snakeandladder;

public class Dice {

	
	int numberOfDice;

	public Dice(int numberOfDice) {
		super();
		this.numberOfDice = numberOfDice;
	}
	
	
public int rollDice() {
	
	
	return (int)(Math.random()*(6*numberOfDice-1*numberOfDice))+1;
	
}
	
	
}
