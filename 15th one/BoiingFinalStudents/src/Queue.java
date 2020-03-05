
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author ME
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {
	
	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> front,rear;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		//TODO: Write the Queue constructor
		front=rear=null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		//TODO:  Needs to return true when empty and false otherwise
		if(front == null){
			return true;
		}else{
			return false;
		}
	    
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		try{
			if(isEmpty()){
				throw new NoSuchElementException();
			}
			
			return front.getElement();

		}catch(NoSuchElementException e){
			throw e;
		}

		
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		//Dequeue code is neede here
		try{
			if(isEmpty()){
				throw new NoSuchElementException();
			}
			
			front=front.getNext();

		}catch(NoSuchElementException e){
			throw e;
		}
		
		
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		//Enqueue code is needed here
		QueueElement<T> newNode=new QueueElement<T>(element,null);
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}else{
			rear.setNext(newNode);
			rear=newNode;
		}
		
		
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		//Code to print the code is needed here
		QueueElement<T> temp=front;
		while(temp!=null){
			System.out.println("Element:"+temp.getElement().toString());
			temp=temp.getNext();
		}
	}
}
