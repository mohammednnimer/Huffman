package application;

import java.util.Stack;



public class Queue<T extends Comparable<T>> {

	linked_List<T> newn;

	public Queue() {
		newn = new linked_List<>();
	}

	public void enqueue(T data) {

newn.insert_notSort(data);	
	}

	public T dequeue() {

		if (newn.isEmpty())	
		{
			//System.out.println("the Equeue is Empty");
			return null;
		}
		return  (T) newn.delet(newn.getTail().getData()).getData();
	}

	public boolean isEmpty() {

		return newn.isEmpty();
	}

	public T getfront() {

		if (newn.isEmpty())	
		{
			//System.out.println("the Equeue is Empty");
			return null;
		}
	
		return newn.getTail().getData();
		
	}

	public void clear() {
		newn.clear();
	}

	public int size()
	{
	return newn.length();

}
}