package application;

import java.time.LocalDate;

public class HNode<T extends Comparable<T>> implements Comparable<HNode<T>> {

	private T data;
	private int flag=0;
	

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	
	public HNode(T data) {
		this.data=data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public int compareTo(HNode<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
