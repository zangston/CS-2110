import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the Ship super class. You don't have edit this class.
 * @author Your friendly CS Professors
 *
 */
public class Ship {
	final static String pathToCSV = "AlienLoveBook.csv";

	/**
	 * This is a private function that loads Aliens from the CSV file
	 * Do not modify the this function.
	 * @param pathToCSV
	 * @return
	 * @throws Exception
	 */
	private static ArrayList<Glootie> loadAliensFromFile(String pathToCSV) throws Exception{
		ArrayList<Glootie> alienArray = new ArrayList<>();
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
		//Read and ignore header row:
		String row = csvReader.readLine();
		//Read remain data from CSV file
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			// Add new Glootie to array
			alienArray.add(new Glootie(data));
		}
		csvReader.close();

		return alienArray;
	}

	/**
	 * This function return an Array List of Aliens
	 * @return ArrayList<Glootie>
	 */

	public static ArrayList<Glootie> getAliens(){
		Logger logger = Logger.getLogger(Ship.class.getName());
		ArrayList<Glootie> aliens = null;
		try {
			aliens = loadAliensFromFile(pathToCSV);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "There was Error while loading the AlienLoveBook.csv"
					+"\n Check to see that you added it to your package."
					+"Don't just Link you must copy it in.");		}
		return aliens;
	}
	/**
	 *
	 * @param g
	 * @param aliens
	 * @return ArrayList<Glootie> matches
	 */
	public static ArrayList<Glootie> findMatches(Glootie g, ArrayList<Glootie> aliens){
		ArrayList<Glootie> matches = new ArrayList<>();
		for(Glootie alien: aliens) {
			if(g.equals(alien))
				matches.add(alien);
		}
		return matches;
	}

	/**
	 * Prints the matches the Ship finds
	 * @param aliens
	 * @param g
	 */
	public static void printMatches(ArrayList<Glootie> aliens, Glootie g) {
		System.out.println("Matches for "+ g);
		ArrayList<Glootie> gMatches = findMatches(g,aliens);
		if(gMatches.size() < 10) {
			System.out.println(gMatches);
		}else {
			System.out.println(gMatches.size() + " matches is too many to print");
		}

	}

}
