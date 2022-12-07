/*
Name:
Computing ID:

*/


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		// TODO: Complete this method to implement the add() method for a Queue
        growIfNecessary();
		this.elements[this.tail] = s;
        this.tail++;
	}
	
	public String remove(){
		// TODO: Complete this method to implement the remove() method for a Queue
        String ret = this.elements[this.head];
        this.elements[this.head] = null;
        this.head++;
        return ret;
	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public void print()
	{
		for(String s : this.elements)
			System.out.println(s);
	}
	
	public static void main(String[] args) {
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
        
		Queue q = new Queue();
		q.add("a");
		q.add("b");
		q.add("c");
		q.print();
		System.out.println();
		q.remove();
		q.add("a");
		q.print();
		
	}

}