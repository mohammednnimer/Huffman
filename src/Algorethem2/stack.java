package Algorethem2;

import application.Queue;

public class stack<T extends Comparable<T>> {
	Queue<T> newn=new Queue<>();

	public void push(T data) {
		Queue<T> temp=new Queue<>();
		if(newn.getfront()==null)
		{	newn.enqueue(data);
			return;	
		}
		
		while (newn.getfront()!=null) {
			temp.enqueue(newn.dequeue());
		
		
		}
		newn.enqueue(data);
		while (temp.getfront()!=null) {
			newn.enqueue(temp.dequeue());
		
		
		}
		
		


	}

	public T pop() {

		return newn.dequeue();

	}

	public T peek() {

		return newn.getfront();

	}

	public boolean isempty() {
		return newn.isEmpty();
	}

	public void clear() {
		newn.clear();
	}

	public int length() {
	 return newn.size();
	}
}
