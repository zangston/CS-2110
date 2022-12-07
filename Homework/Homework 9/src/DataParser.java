import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * DataParser will read the name.basics.tsv file, provided by the IMDB data set:
 * https://datasets.imdbws.com/ You must have name.basics.tsv in the root of
 * your project folder. DataParser will convert this tab-delimited data file
 * into two data structures one is a list structure, using an ArrayList<Actor>
 * the other is a tree structure, ActorTree, which you will write.
 * 
 * @author Your friendly CS professors
 *
 */
public class DataParser {

	ArrayList<Actor> listDataStore;
	// if you want to run this program without the tree, comment this line out
	ActorTree treeDataStore;

	public DataParser(File inputFile, int maximumNumberOfRecordsToLoad) {

		listDataStore = new ArrayList<Actor>();
		// if you want to run this program without the tree, comment this line out
		treeDataStore = new ActorTree();
		BufferedReader objReader = null;
		try {
			objReader = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = objReader.readLine()) != null) {
				try {
					String v[] = line.split("\t");
						Actor a = new Actor(v[0], v[1], v[2], v[3], v[4], v[5]);
						listDataStore.add(a);
						// if you want to run this program without the tree, comment this line out
						treeDataStore.insert(a);
						if (listDataStore.size() >= maximumNumberOfRecordsToLoad) {
							// exit the loop
							break;
						}

				} catch (Exception e) {
					// just skip this line and try to continue
					System.out.println("Error generating an Actor object from this line, skipping.");
				}

			}
		} catch (Exception e) {
			System.out.println("Reading  file");
		} finally {

			try {
				if (objReader != null)
					objReader.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Data loaded, ready to query.");
	}

	/**
	 * @return the listDataStore
	 */
	public ArrayList<Actor> getListDataStore() {
		return listDataStore;
	}

	/**
	 * @param listDataStore the listDataStore to set
	 */
	public void setListDataStore(ArrayList<Actor> listDataStore) {
		this.listDataStore = listDataStore;
	}

	/**
	 * @return the treeDataStore
	 */
	public ActorTree getTreeDataStore() {
		return treeDataStore;
	}

	/**
	 * @param treeDataStore the treeDataStore to set
	 */
	public void setTreeDataStore(ActorTree treeDataStore) {
		this.treeDataStore = treeDataStore;
	}

}
