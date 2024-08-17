package application;

import java.time.LocalDate;
import java.util.Objects;

public class Date_Record implements Comparable<Date_Record> {

	private AVL_Tree<Martyr> martyr=new AVL_Tree<>();
	private LocalDate  date ;
	private int flag=0;

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	public AVL_Tree<Martyr> getMartyr() {
		return martyr;
	}



	public void setMartyr(AVL_Tree<Martyr> martyr) {
		this.martyr = martyr;
	}



	@Override
	public String toString() {
		return "Date_Record [date=" + date + "]";
	}

 

    public Date_Record(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
	public Date_Record(int  year,int mounth,int day) {
		super();
		this.date = LocalDate.of(year, mounth, day);
	}
	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date_Record other = (Date_Record) obj;
		return Objects.equals(date, other.date);
	}
	@Override
	public int compareTo(Date_Record o) {
		return this.date.compareTo(o.date);
	}	
}
