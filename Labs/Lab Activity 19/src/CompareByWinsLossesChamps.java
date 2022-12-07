import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if(a.getNumberOfWins() > b.getNumberOfWins())
			return -1;
		else if(a.getNumberOfWins() < b.getNumberOfWins())
			return 1;
		
		if(a.getNumberOfLosses() < b.getNumberOfLosses())
			return -1;
		else if(a.getNumberOfLosses() > b.getNumberOfLosses())
			return 1;
		
		if(a.getNumberOfChampionships() > b.getNumberOfChampionships())
			return -1;
		else if(a.getNumberOfChampionships() < b.getNumberOfChampionships())
			return 1;
		
		return 0;
	}

}