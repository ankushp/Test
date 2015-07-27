
import java.util.Random;
public class Player {
	public String name;
	public int pointsInGameWon;
	public int gamesInSetWon;
	public int setsInMatchWon;
	
	public boolean hasAdvantage;
	public static Random rand = new Random();
	
	public Player(String name) {
		this.name = name;
		hasAdvantage = false;
	}
	
	public static void playPoint(Player player1,Player player2) {
		int getPoint = rand.nextInt(10);
		//System.out.println(getPoint);
		if(getPoint < 5) {
			player1.incrementPoint(player2);
		}
		else {
			player2.incrementPoint(player1);
		}
	}
	
	public void incrementPoint(Player opp) {
		if(pointsInGameWon == 0) {
			pointsInGameWon = 15;
		}
		else if (pointsInGameWon == 15) {
			pointsInGameWon = 30;
		}
		else if (pointsInGameWon == 30) {
			pointsInGameWon = 40;
		}
		//Score options when there is an advantage
		else if(pointsInGameWon == 40 && hasAdvantage) {
				hasAdvantage = false;
				opp.hasAdvantage = false;
				pointsInGameWon = 0;
				opp.pointsInGameWon = 0;
				this.incrementGame(opp);
		}
		
		//Goes back to deuce if wins point when opp has advantage
		else if(pointsInGameWon == 40 && opp.hasAdvantage) {
			opp.hasAdvantage = false;
			hasAdvantage = false;
		}
		
		else if(pointsInGameWon == 40) {
			//PLayer gets advantage when wins point at deuce
			if(opp.pointsInGameWon == 40) {
				hasAdvantage = true;
			}
			
			//Not at deuce so player wins the game.
			else {
				opp.hasAdvantage = false;
				hasAdvantage = false;
				pointsInGameWon = 0;
				opp.pointsInGameWon = 0;
				this.incrementGame(opp);
			}
		}
		
	}
	
	//Plays a game between two players
	public static void playGame(Player player1,Player player2) {
		Player.playPoint(player1, player2);
	}
	
	public static void playSet(Player player1, Player player2) {
		player1.hasAdvantage = false;
		player2.hasAdvantage = false;
		player1.gamesInSetWon = 0;
		player2.gamesInSetWon = 0;
		player1.pointsInGameWon = 0;
		player2.pointsInGameWon = 0;
		player1.setsInMatchWon = 0;
		player2.setsInMatchWon = 0;
		
		while(player1.setsInMatchWon == 0 && player2.setsInMatchWon == 0) {
			Player.playGame(player1, player2);
		}
		
	}
	
	//Increments the number of games a player has won in a set.
	public void incrementGame(Player opp) {
		
		//Plays a tiebreaker if tied at 6-6
//		if(gamesInSetWon + 1 == 6 && opp.gamesInSetWon == 6) {
//			Player.tieBreaker(this,opp);
//		}
		
		//Case when a player wins enough games to win a set.
		if(gamesInSetWon + 1 >= 6 && (gamesInSetWon + 1) - opp.gamesInSetWon >= 2) {
			pointsInGameWon = 0;
			opp.pointsInGameWon = 0;
			
			hasAdvantage = false;
			opp.hasAdvantage = false;
			
			System.out.println(this.name + " won the set " + (this.gamesInSetWon + 1) + "-" + opp.gamesInSetWon);
			
			gamesInSetWon = 0;
			opp.gamesInSetWon = 0;
			setsInMatchWon += 1;
		}
		
		//If don't win set, just add another game win total.
		else {
			pointsInGameWon = 0;
			opp.pointsInGameWon = 0;
			
			hasAdvantage = false;
			opp.hasAdvantage = false;
			gamesInSetWon += 1;
		}
	}
	
	//Simulates a tiebreaker situation.
	public static void tieBreaker(Player player1, Player player2) {
	}
}
