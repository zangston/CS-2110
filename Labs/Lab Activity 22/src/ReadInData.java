import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInData {
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine()); // Read in Val for # values
			for(int i = 0; i < numOfValues; i++) { // for-loop to get that many values
				sum += scan.nextDouble(); // add the values together (doubles)
			}
			scan.close();
			return sum; // return the sum of all the values in the file 
		}//add catch statements here		
		catch(FileNotFoundException e) {
			System.out.println("Couldn't find file " + e);
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid number format " + e);
			e.printStackTrace();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input type " + e);
			e.printStackTrace();
		}
		catch(RuntimeException e) {
			System.out.println("Error on runtime " + e);
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("An error occured " + e);
			e.printStackTrace();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt")); // notice spelling of the file name! 
		System.out.println(readData("Test4.txt"));
	}

}