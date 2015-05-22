package tennis;

public class Jeu
{
	// Déclarations des variables
	private int ScoreJoueur1 = 0;
	private int ScoreJoueur2 = 0;
	private String nomJoueur2;
	private String nomJoueur1;
	
	// Constructeur
	public Jeu(String playerOneName, String playerTwoName)
	{
		this.nomJoueur1 = playerOneName;
		this.nomJoueur2 = playerTwoName;
	}

	public String getScore()
	{
		if (hasWinner())
		{
			return playerWithHighestScore() + " gagne";
		}
		
		if (hasAdvantage()) 
		{ 
			return "Avantage " + playerWithHighestScore(); 
		}
		
		if (isDeuce())
			return "Egalité";
		
		if(ScoreJoueur1 == ScoreJoueur2)
		{
			return translateScore(ScoreJoueur1) + " All";
		}
		
		return translateScore(ScoreJoueur1) + "," + translateScore(ScoreJoueur2);
	}

	private boolean isDeuce() 
	{
		return ScoreJoueur1 >= 3 && ScoreJoueur2 == ScoreJoueur1;
	}
	
	private String playerWithHighestScore()
	{
		if (ScoreJoueur1 > ScoreJoueur2) {
			return nomJoueur1;
		} 
		else
		{
			return nomJoueur2;
		}
	}
	
	private boolean hasWinner() 
	{
		if(ScoreJoueur2 >= 4 && ScoreJoueur2 >= ScoreJoueur1 + 2 )
			return true;
		if(ScoreJoueur2 >= 4 && ScoreJoueur1 >= ScoreJoueur2 + 2)
			return true;
		return false;
	}
	
	private boolean hasAdvantage()
	{
		if (ScoreJoueur2 >= 4 && ScoreJoueur2 == ScoreJoueur1 + 1)
			return true;
		if (ScoreJoueur1 >= 4 && ScoreJoueur1 == ScoreJoueur2 + 1)
			return true;
		return false;
	}

	public void playerOneScores()
	{
		ScoreJoueur1++;
	}

	public void playerTwoScores()
	{
		ScoreJoueur2++;
	}
	
	private String translateScore(int score) 
	{
		switch (score) 
		{
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1: 
			return "Fifteen";
		case 0:
			return "Zero";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}
}
