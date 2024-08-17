package application;

import java.util.ArrayList;

public class Distict {
	String name;
	ArrayList<String> locaion=new ArrayList<>();
	
	
	
	
	
	
	
	
	public String find(String name)
	{
		
		
		
		for(int i=0;i<locaion.size();i++)
		{
			if(locaion.get(i).trim().toLowerCase().compareTo(name.trim().toLowerCase())==0)
				return locaion.get(i);
			
			
			
		}
		return null;
		
	}
	

}
