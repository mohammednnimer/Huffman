package application;

import java.util.Objects;

public class Martyr implements Comparable<Martyr> {

	private String name;

	private int age;

	private char Gender;
	private String District;
	private String Location;

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	

	@Override
	public String toString() {
		return "Martyr [name=" + name + ", age=" + age + ", Gender=" + Gender + ", District=" + District + ", Location="
				+ Location + "]";
	}

	public Martyr(String name, int age, char gender) {
		
		this.name = name;
		this.age = age;
		this.Gender=gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Martyr other = (Martyr) obj;
		return Objects.equals(name, other.name);
	}

	public Martyr(String name, int age, char gender, String district, String location) {
		super();
		this.name = name;
		this.age = age;
		Gender = gender;
		District = district;
		Location = location;
	}

	public Martyr() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		
		Gender = gender;
		
	}

	@Override
	public int compareTo(Martyr o) {
		if(this.District.compareTo(o.District)!=0)
		{
		         return this.District.compareTo(o.District);
		}
		return this.name.compareTo(o.name);
	}
	
	
	
	
	
	
}
