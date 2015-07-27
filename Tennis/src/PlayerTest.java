import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

//	@Test
//	public void testPlayGame() {
//		Player player1 = new Player("Roger Federer");
//		Player player2 = new Player("Rafael Nadal");
//		Player.playGame(player1, player2);
//	}
	
	@Test
	public void testPlaySet() {
		int FedCount = 0;
		int NadCount = 0;
		for(int x = 0; x < 10; x ++) {
			Player player1 = new Player("Roger Federer");
			Player player2 = new Player("Rafael Nadal");
			Player.playSet(player1, player2);
			if(player1.setsInMatchWon == 1) {
				FedCount += 1;
			}
			if(player2.setsInMatchWon == 1) {
				NadCount += 1;
			}
		}
		System.out.println("The series between Federer and Nadal is: " + FedCount + " - " + NadCount);
	}

}
