package tennis ;

import junit.framework.TestCase;

public class TennisTest extends TestCase {
	
	Jeu jeu = new Jeu("Hitler" , "Staline");
	
	public void testNouveauJeuRetourneZeroAll()
	{
		String score = jeu.getScore();
		
		assertEquals("Zero All", score);
	}
	
	public void testJoueur1Gagne1erEchange()
	{
		jeu.playerOneScores();

		String score = jeu.getScore();
		assertEquals("Fifteen,Zero", score);		
	}
	
	public void testFifteenAll(){
		jeu.playerOneScores();
		jeu.playerTwoScores();
		
		String score = jeu.getScore();
		assertEquals("Fifteen All", score);
	}
	
	public void testJoueur2Gagne2PremiersEchanges() {
		createScore(0, 2);
		
		String score = jeu.getScore();
		assertEquals("Zero,Thirty", score);
	}

	public void testJoueur1Gagne3PremiersEchanges(){
		createScore(3, 0);
		String score = jeu.getScore();
		assertEquals("Forty,Zero", score);
	}
	
	public void testEgalité() {
		createScore(3, 3);
		
		String score = jeu.getScore();
		assertEquals("Egalité", score);		
	}
	
	public void testJoueur2GagneJeu(){
		createScore(1,4);
		
		String score = jeu.getScore();
		assertEquals("Staline gagne", score);
	}
	
	public void testJoueurEgalité4() {
		createScore(4, 4);
		String score = jeu.getScore();
		assertEquals("Egalité", score);		
	}

	public void testJoueur2Avantage(){
		createScore(4, 5);
		
		String score = jeu.getScore();
		assertEquals("Avantage Staline", score);
	}

	public void testJoueur1Avantage(){
		createScore(5, 4);
		
		String score = jeu.getScore();
		assertEquals("Avantage Hitler", score);
	}
	
	public void testJoueur2Gagne(){
		createScore(2, 4);
		String score = jeu.getScore();
		assertEquals("Staline gagne", score);
	}
	
	public void testJoueur2GagneApresAvantage() {
		createScore(6, 8);
		String score = jeu.getScore();
		assertEquals("Staline gagne", score);
	}
	
	public void testJoueur1GagneApresAvantage() {
		createScore(8, 6);
		String score = jeu.getScore();
		assertEquals("Hitler gagne", score);
	}
	
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			jeu.playerOneScores();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			jeu.playerTwoScores();
		}
	}
}
