import java.util.ArrayList;
import java.util.Collections;

public class ComparatorTester {

	public static void main(String[] args) {
		BasketBallTeam warriors = new BasketBallTeam("Warriors", 125.6, 23001, 19000, 3, true);
		BasketBallTeam cavs = new BasketBallTeam("Cavs", 130.8, 18003, 25002, 1, true);
		BasketBallTeam lakers = new BasketBallTeam("Lakers", 85.9, 25013, 17026, 7, false);
		BasketBallTeam bucks = new BasketBallTeam("Bucks", 95.2, 18003, 29876, 2, false);
		BasketBallTeam magic = new BasketBallTeam("Magic", 87.2, 18003, 29876, 0, false);
		
		ArrayList<BasketBallTeam> list = new ArrayList<BasketBallTeam>();
		list.add(magic);
		list.add(bucks);
		list.add(lakers);
		list.add(cavs);
		list.add(warriors);
		
		System.out.println("Original List:\n" + list);
		System.out.println("");
		Collections.sort(list,new CompareByPlayoffsAndSalary());
		System.out.println("CompareByPlayoffsAndSalary " +  list);
		Collections.sort(list, new CompareByWinsLossesChamps());
		System.out.println("CompareByWinsLossesChamps  " + list);
		/*Output should be
		 * [Magic, Bucks, Lakers, Cavs, Warriors]
		   [Warriors, Cavs, Lakers, Magic, Bucks]
		   [Lakers, Warriors, Cavs, Bucks, Magic]

		 */
		
	}

}