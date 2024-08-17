package application;

import java.util.Stack;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class Date_Scene {

	QuadraticHash<Date_Record> date;
	private Queue<Date_Record> queue = new Queue<>();
	private Date_Record Negative;

	public Date_Record getNegative() {
		return Negative;
	}

	public void fromto() {
		while (queue.getfront().getDate().compareTo(Negative.getDate()) != 0) {
			stack.push(queue.dequeue());
		}
	}

	public int total() {
		return Negative.getMartyr().levelOrderTraversal().size();

	}

	public double avg() {
		Queue<Martyr> m1 = Negative.getMartyr().levelOrderTraversal();
		int n = m1.size();
		double sum = 0;
		while (!m1.isEmpty()) {
			sum += m1.dequeue().getAge();
		}
		return sum / n;

	}

	public String district() {
		Queue<Martyr> m1 = Negative.getMartyr().levelOrderTraversal();
		String name = m1.getfront().getDistrict();
		Queue<Martyr> m2;
		int max = 0;
		int i = 0;
		while (m1.getfront() != null) {
			m2 = m1;
			i = 0;
			while (!m2.isEmpty()) {

				if (m1.getfront().getDistrict().compareTo(m2.dequeue().getDistrict()) == 0) {
					i++;
				}
			}
			if (i > max && m1.getfront() != null) {
				max = i;
				name = m1.getfront().getDistrict();
			}
			m1.dequeue();
		}

		return name;

	}

	public String Location() {
		Queue<Martyr> m1 = Negative.getMartyr().levelOrderTraversal();
		String name = m1.getfront().getLocation();
		Queue<Martyr> m2;
		int max = 0;
		int i = 0;
		while (m1.getfront() != null) {
			m2 = m1;
			i = 0;
			while (!m2.isEmpty()) {
				if (m1.getfront().getLocation().compareTo(m2.dequeue().getLocation()) == 0) {
					i++;
				}
			}
			if (i > max && m1.getfront() != null) {
				max = i;
				name = m1.getfront().getLocation();
			}
			m1.dequeue();
		}
		return name;
	}

	public Stack_Linked_list<Date_Record> getStack() {
		return stack;
	}

	public void setStack(Stack_Linked_list<Date_Record> stack) {
		this.stack = stack;
	}

	public Queue<Date_Record> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Date_Record> queue) {
		this.queue = queue;
	}

	public void setNegative(Date_Record negative) {
		Negative = negative;
	}

	private Stack_Linked_list<Date_Record> stack = new Stack_Linked_list<>();

	public QuadraticHash<Date_Record> getDate() {
		return date;
	}

	public void setDate(QuadraticHash<Date_Record> date) {
		this.date = date;
	}

	public void print(TableView<String> table) {
		table.getItems().clear();
		HNode<Date_Record>[] newn = date.getNewn();
		for (int i = 0; i < newn.length; i++) {
			if (newn[i].getData() != null) {
				table.getItems().add(i + "   " + newn[i].getData().toString() + "         " + newn[i].getFlag());
			}

		}

	}

	public void print_Empty(TableView<String> table) {
		table.getItems().clear();
		HNode<Date_Record>[] newn = date.getNewn();
		for (int i = 0; i < newn.length; i++) {
			if (newn[i].getData() == null) {
				table.getItems().add("");
			} else {
				table.getItems().add(i + "   " + newn[i].getData().toString() + "        " + newn[i].getFlag());
			}

		}

	}

	public void print1(TableView<String> table) {
		table.getItems().clear();
		Queue<Date_Record> queue = date.traverce();
		if (queue != null && !queue.isEmpty()) {
			while (!queue.isEmpty()) {
				try {
					Date_Record rec = queue.dequeue();
					if (rec != null) {
						table.getItems().add(rec.toString());
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public void print_with_empty(TableView<String> table) {
		table.getItems().clear();
		Queue<Date_Record> queue = date.traverce();
		if (queue != null && !queue.isEmpty()) {
			while (!queue.isEmpty()) {
				try {
					Date_Record rec = queue.dequeue();
					if (rec != null) {
						table.getItems().add(rec.toString());
					} else {
						table.getItems().add("");
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public Date_Record delet(Date_Record d1) {

		return date.delete(d1);
	}

	public void abload() {

		
		
		HNode<Date_Record>[] newn = date.getNewn();
		for (int i = 0; i < newn.length; i++) {
			if (newn[i].getData() != null&&newn[i].getFlag()!=2) {
            queue.enqueue(newn[i].getData());

			}

		}		
		
		

	}

	public Date_Record next() {

		if (queue.getfront() == null) {
			return null;
		}

		Date_Record ddd = (Date_Record) queue.dequeue();

		if (queue.getfront() == null) {
			queue.enqueue(ddd);
			return null;
		}

		stack.push(ddd);
		Date_Record dd = (Date_Record) queue.getfront();

		return dd;

	}

	public Date_Record prev() {

		Date_Record dd = (Date_Record) stack.peek();
		if (dd == null) {
			return null;
		}
		insertAtBottom(queue, (Date_Record) stack.pop());

		return dd;

	}

	private void insertAtBottom(Queue<Date_Record> queue, Date_Record data) {

		if (queue.isEmpty()) {
			queue.enqueue(data);
		} else {

			int size = queue.size();
			Date_Record[] temp = new Date_Record[size];
			for (int i = 0; i < size; i++) {
				temp[i] = (Date_Record) queue.dequeue();
			}

			queue.enqueue(data);

			for (int i = 0; i < size; i++) {
				queue.enqueue(temp[i]);
			}
		}

	}

}
