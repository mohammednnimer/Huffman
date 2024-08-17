package application;

public class Node<T extends Comparable<T>> {

	Node next;
	T data;
	public Node( T data) {
		this.data=data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
