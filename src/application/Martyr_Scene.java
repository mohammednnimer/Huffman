package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class Martyr_Scene {
	AVL_Tree<Martyr> m1 = new AVL_Tree<>();

	public AVL_Tree<Martyr> getM1() {
		return m1;
	}

	public void setM1(AVL_Tree<Martyr> m1) {
		this.m1 = m1;
	}

	public void marter(TableView<Martyr> mm) {
		mm.getItems().clear();
		ArrayList<Martyr_Node> newn = new ArrayList<>();
		Queue<Martyr> d1 = m1.levelOrderTraversalRev();
		Martyr_Node mar;
		while (!d1.isEmpty()) {
			
			mar = new Martyr_Node(d1.getfront());

			newn.add(mar);
			d1.dequeue();
		}
		Heab<Martyr_Node> martyr = new Heab<>(5);

		
		
		Martyr_Node[] array = new Martyr_Node[newn.size()+1];
		array = newn.toArray(array);
		array[0]=new Martyr_Node(new Martyr());
		for(int i=1;i<array.length;i++)
		{
			
			array[i]=newn.get(i-1);
			
		}
		
		martyr.sort(array);

		for (int i = 1; i < array.length; i++) {

			mm.getItems().add(array[i].getM1());
		}

	}

	

	public void abload_name(ComboBox<String> n)
	{
	n.getItems().clear();	
	if(m1.root!=null) {
		Queue<Martyr> n1=m1.levelOrderTraversal();
		while (!n1.isEmpty()) {
	
			n.getItems().add(n1.dequeue().getName());
			
		}
		
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void name(TableView<Martyr> mm) {
		mm.getItems().clear();
		Queue<Martyr> d1 = m1.levelOrderTraversalRev();
		if (d1 == null) {
			return;
		}
		while (!d1.isEmpty()) {

			mm.getItems().add(d1.dequeue());

		}

	}

	public void search(TableView<Martyr> mm, String name) {
		mm.getItems().clear();
		Queue<Martyr> d1 = m1.levelOrderTraversalRev();
		if (d1 == null) {
			return;
		}
		while (!d1.isEmpty()) {
			if (d1.getfront().getName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
				System.out.println(d1.getfront());
				mm.getItems().add(d1.dequeue());
			}

		}

	}

	public int size() {
		if (m1.levelOrderTraversal() == null)
			return 0;
		return m1.levelOrderTraversal().size();
	}

	public int heigth() {
		if (m1.levelOrderTraversal() == null)
			return 0;
		return m1.height();

	}

	public Martyr delet(String name) {
		Queue<Martyr> d1 = m1.levelOrderTraversalRev();
		Martyr m2 = null;
		while (!d1.isEmpty()) {
			if (name.toLowerCase().compareTo(d1.getfront().getName().toLowerCase()) == 0) {
				m2 = d1.getfront();
				m1.delete(m2);
				return m2;

			}
			d1.dequeue();

		}
		return null;

	}

}
