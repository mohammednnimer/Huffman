package Algorethem2;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	
	TNode<T> n;
	
	public Node(TNode<T> n) {
		this.n=n;
	}

	public TNode<T> getN() {
		return n;
	}
	
	public void setN(TNode<T> n) {
		this.n = n;
	}

	@Override
	public int compareTo(Node<T> o) {
		// TODO Auto-generated method stub
		return n.getData().compareTo(o.getN().getData());
	}
	
}
