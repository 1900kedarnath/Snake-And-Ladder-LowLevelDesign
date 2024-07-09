package snakeandladder;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Board {
	
	
	Queue<Player> player;
	List<Jumper> snake;
	List<Jumper> ladder;
	int boardSize;
	Dice dice;
	Map<String,Integer> playerPosition;
	
	Board(Queue<Player> player,List<Jumper> snake,List<Jumper> ladder,int boardSize,Dice dice,Map<String,Integer> playerPosition){
		
		this.player=player;
		this.snake=snake;
		this.ladder=ladder;
		this.boardSize=boardSize;
		this.dice=dice;
		this.playerPosition=playerPosition;
	}
	
	 
	public void start() {
		
		
		while(!player.isEmpty()) {
		Player p=player.poll();
		String playerName=p.getName() ;
		int currentPosition=playerPosition.get(playerName);
		
//		System.out.println("Press Enter key for rolling dice");
//		Scanner sc=new Scanner(System.in);
//		sc.nextLine();
//		sc.close();
		int diceValue=dice.rollDice();
		System.out.println(diceValue+" dice "+currentPosition);
		if(currentPosition+diceValue>boardSize) {
			player.offer(p);
		}
		else {
			boolean flag=false;
			playerPosition.put(playerName, currentPosition+diceValue);
			player.offer(p);
			snake.stream().forEach(s->{
			
				if(currentPosition+diceValue==s.end) {
					playerPosition.put(playerName, s.start);
					
					System.out.println("Player "+playerName+" beaten by snake "+s.start);
				}
				
			});
			
			ladder.stream().forEach(ladder->{
				if(currentPosition+diceValue==ladder.start) {
					playerPosition.put(playerName, ladder.end);
					
					System.out.println("Player "+playerName+" get ladder "+ladder.end);
					
				}
				
				
			});
			
			if(currentPosition+diceValue==boardSize)
			{
				System.out.println("Winner Is"+" "+playerName);
				break;
			}
			
			
		}
		
		
		
		
		}
		
		
		
		
	}
	
	

}
