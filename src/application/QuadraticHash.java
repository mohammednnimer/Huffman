package application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class QuadraticHash<T extends Comparable<T>> {
	HNode<T>[] newn;
	int number = 0;

	public QuadraticHash(int n) {
		newn = new HNode[n];
		inttliezed();

	}

	private void inttliezed() {
		for (int i = 0; i < newn.length; i++) {
			newn[i] = new HNode<>(null);
		}

	}

	public Queue<T> traverce() {
		Queue<T> queue = new Queue<>();
		for (int i = 0; i < newn.length; i++) {
			try {

				newn[i].getData().getClass();
				queue.enqueue(newn[i].getData());

			} catch (Exception e) {

			}

		}

		return queue;

	}

	public T search(T data) {

		if (data == null)
			return null;

		int x = data.hashCode() % newn.length;
		int i = 1;

		while (newn[x].getFlag() != 0) {
			if (newn[x].getData().compareTo(data) == 0) {
				return newn[x].getData();
			}

			x = (data.hashCode() + i * i) % newn.length;
			i++;
		}
		return null;

	}

	public HNode<T>[] getNewn() {
		return newn;
	}

	public void setNewn(HNode<T>[] newn) {
		this.newn = newn;
	}

	public void insert(T data) {
		if (data == null)
			return;
		number++;
		if (number > newn.length / 2) {
			resc();
		}

		int x = data.hashCode() % newn.length;
		int i = 1;

		while (newn[x].getFlag() != 0 && newn[x].getFlag() != 2) {
			x = (data.hashCode() + (i * i)) % newn.length;
			i++;
		}
		newn[x] = new HNode<>(data);
		newn[x].setFlag(1);
	}

	private void resc() {
		HNode<T>[] temp = newn;
		newn = new HNode[prime(temp.length * 2)];
		inttliezed();
		number = 0;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i].getFlag()!=2)
			insert(temp[i].getData());
		}

	}

	private int prime(int m) {
		int n = 2;
		int y = 0;
		boolean x = true;
		for (; true; m++) {
			x = true;
			for (n = 2; n <= m / 2; n++) {
				if (m % n == 0) {
					x = false;
					break;
				}
			}
			if (x)
				break;

			y++;
			if (y == 20)
				break;
		}

		return m;

	}

	public HNode<T> find(T data) {
		if (data == null)
			return null;

		int x = data.hashCode() % newn.length;
		int i = 1;
		while (newn[x].getFlag() != 0) {

			if (newn[x].getFlag() != 2)
				if (newn[x].getData().compareTo(data) == 0)
					return newn[x];

			x = (data.hashCode() + i * i) % newn.length;
			i++;
		}
		return null;

	}

	public T delete(T data) {
		if (data == null)
			return null;

		int x = data.hashCode() % newn.length;
		int i = 1;

		while (newn[x].getFlag() != 0) {
			if (newn[x].getData().compareTo(data) == 0) {

				T dat = newn[x].getData();
				// newn[x] = new HNode<>(null);
				newn[x].setFlag(2);
				number--;
				return dat;
			}
			x = (data.hashCode() + i * i) % newn.length;
			i++;
		}

		return null;

	}

}
