import java.util.ArrayList;

/**
 *                  `. ___
                    __,' __`.                _..----....____
        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'
  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'
,'________________                          \`-._`-','
 `._              ```````````------...___   '-.._'-:
    ```--.._      ,.                     ````--...__\-.
            `.--. `-`                       ____    |  |`
              `. `.                       ,'`````.  ;  ;`
                `._`.        __________   `.      \'__/`
                   `-:._____/______/___/____`.     \  `
                               |       `._    `.    \
                               `._________`-.   `.   `.___
                                             SSt  `------'`
 * @author Your friendly CS Professors
 * This is the main entry point for your program. Run this file.
 * Don't edit this file. You only need to edit Glootie.java
 */
public class Mothership extends Ship {
	
	
	public static void main(String[] args) {
		//Load Aliens from file
		ArrayList<Glootie> aliens = getAliens();
		
		//Create Alien profile for Rick 
		Glootie rick = new Glootie(70, "A", 99.0, "Pickle Rick");
		
		//Create Alien profile for Leela
		Glootie leela = new Glootie(45, "D",117.5, "Turanga Leela");
		
		//Print Rick's Matches
		printMatches(aliens, rick);
		
		//Print Leela's Matches
		printMatches(aliens, leela);
		
		
	}

	
}
