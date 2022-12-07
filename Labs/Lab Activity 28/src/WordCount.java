
/**
   Counts how many words in a file.
 */
public class WordCount
{
    public static void main(String argv[]) throws InterruptedException {

        argv = new String[4];
        // make sure to match file names exactly (including the extension) 
        // these become the input arguments to the program (4 arguments; the four "books") 
        argv[0] = "BramStoker-Dracula.txt";
        argv[1] = "mary1.txt";
        argv[2] = "shakespeare-hamlet.txt";
        argv[3] = "shakespeare-macbeth.txt";
        
        Thread[] arr = new Thread[4];
        
        // A new thread is created for EACH argument (file) provided
        for (int i = 0; i < argv.length; i++) {
            WordCountRunnable wcr = new WordCountRunnable(argv[i]);
            // Note: An error will be on the next line until you finalize the WordCountRunnable file! 
            Thread t = new Thread(wcr); // create a thread 
            t.start(); // call the start() method on the thread, which will call run()
            arr[i] = t;
        }
        
        for(int i = 0; i < arr.length; i++)
        {
        	arr[i].join();
        }
        
        System.out.println("Total: " + WordCountRunnable.combinedWordCount);
    }
}