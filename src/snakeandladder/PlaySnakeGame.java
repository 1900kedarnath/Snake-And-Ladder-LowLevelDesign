package snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PlaySnakeGame {
	
	
	
	public static void main(String [] arg) {
		
		
		
		
		
		int boardSize=100;
		Dice dice=new Dice(1);
		Map<String,Integer> playerPosition=new HashMap<>();	
		playerPosition.put("Kedar", 0);
		playerPosition.put("Badri", 0);
		
	Player p1=new Player("Kedar",2);
	Player p2=new Player("Badri",3);
		
	Queue<Player> player=new LinkedList<>();
	player.add(p1);
	player.add(p2);
	
	List<Jumper> snake=new ArrayList<>();
	
	snake.add(new Jumper(80,50));
	snake.add(new Jumper(45,10));
	snake.add(new Jumper(99,0));
	
	List<Jumper> ladder=new ArrayList<>();
	
	ladder.add(new Jumper(5,30));
	ladder.add(new Jumper(40,81));
	ladder.add(new Jumper(75,98));
	
		
		
	
	
	Board board=new Board( player, snake, ladder, boardSize, dice, playerPosition);
	board.start();

	}
	
	

}
