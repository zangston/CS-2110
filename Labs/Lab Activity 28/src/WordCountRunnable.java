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
import java.util.Scanner;
import java.util.concurrent.locks.*;

/**
   Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable {
    private String filename;
    static int threadCount;
    static int combinedWordCount;
    private Lock combinedCountLock;
    
    /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count words
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
        combinedCountLock = new ReentrantLock();
    }

    public void run() {
    	
    	threadCount++;
    	
    	combinedCountLock.lock();
    	try 
    	{
    		Scanner input = new Scanner(new FileInputStream(filename));
    		int count = 0;
    		while(input.hasNext()) {
    			count++;
    			input.next();
    		}
    		System.out.println(filename + ": " + count);
    		combinedWordCount += count;
    		
    	} catch(FileNotFoundException e) {
    		System.out.println("File not found" + e);
    		e.printStackTrace();
    	} catch(Exception e) {
    		System.out.println("An error occurred" + e);
    		e.printStackTrace();
    	} finally {
    		combinedCountLock.unlock();
    	}
    	
    	threadCount--;
    }
}