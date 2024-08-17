package application;

public class Martyr_Node implements Comparable<Martyr_Node> {

	private Martyr m1;
	public Martyr_Node(Martyr m2)
	{
		m1=m2;
	}
	
	
	
	public Martyr getM1() {
		return m1;
	}
	public void setM1(Martyr m1) {
		this.m1 = m1;
	}
	@Override
	public int compareTo(Martyr_Node o) {
		
		return this.m1.getAge()-o.getM1().getAge();
	}
	
}
