/*
 * CS 2110
 * Professor Graham
 * Lab 27
 * WordCountRunnable.java
 * Winston Zhang
 * 10 November 2020
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
   Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable{
    private String filename;

    /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count words
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
    }

    public void run() {
        //add your code here:
    	
    	try 
    	{
    		Scanner input = new Scanner(new FileInputStream(filename));
    		int count = 0;
    		while(input.hasNext()) {
    			count++;
    			input.next();
    		}
    		System.out.println(filename + ": " + count);
    		
    	} catch(FileNotFoundException e) {
    		System.out.println("File not found" + e);
    		e.printStackTrace();
    	} catch(IOException e) {
    		System.out.println("File unable to be read" + e);
    		e.printStackTrace();
    	} catch(Exception e) {
    		System.out.println("An error occurred" + e);
    		e.printStackTrace();
    	}
    	

    	
        // hints:
        // initialize a counter
        // create Scanner - can use, ... new Scanner(new FileInputStream(filename))
        // don't forget try-catch	  
        // while loop 
        //      count individual words
        // what are you going to catch??
        // print statement of the format:  filename: wordCount
    }
}