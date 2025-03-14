package Algorethem2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Algorethem2.Hash;
import Algorethem2.Min_Heab;
import Algorethem2.TNode;
import Algorethem2.TableHufman;

public class Main1 {
	static int[] haf = new int[256];
	static int counter = 0;
	 static ArrayList<TableHufman> tableHufman=new ArrayList<>();
	static  String namefile;

	static String heead;

	
	
	public static void main(String[] args) throws IOException {
		

	      if (args.length == 0) {
	            System.out.println("No file selected");
	            return;
	        }

	        String filePath = args[0];
	        File file = new File(filePath);

	        if (!file.exists()) {
	            System.out.println("maaa feeee file");
	            return;
	        }
		
		
		File f1 = file;
        String[][] table;
		try {
			Min_Heab<Integer> heab = new Min_Heab<>(10);
			FileInputStream f2 = new FileInputStream(f1);
			int n = 0;
			int counter = 0;
			byte[] buffer = new byte[32];
			while ((n = f2.read(buffer)) != -1) {
				for (int i = 0; i < n; i++) {
					int unsignedByte = buffer[i] & 0xFF;
					haf[unsignedByte]++;
					//System.out.println(unsignedByte);
				}
			}
			byte[] Bufferout = new byte[16];
			ArrayList<Integer> newn = new ArrayList<>();
			for (int i = 0; i < haf.length; i++) {

				if (haf[i] > 0) {
					{
						newn.add(haf[i]);
						TNode<Integer> n1 = new TNode<Integer>(i);
						n1.setFreq(haf[i]);
						heab.insert(n1);
					}
				}
			}
			for (int i = 0; i < newn.size() - 1; i++) {
				TNode<Integer> newnode = new TNode<>();
				TNode<Integer> x = heab.deletMin();
				TNode<Integer> y = heab.deletMin();
				newnode.setLeft(x);
				newnode.setRigth(y);
				newnode.setFreq(x.getFreq() + y.getFreq());
				heab.insert(newnode);
			}
			TNode<Integer> root=heab.deletMin();
			heab.insert(root);
			tran(root, "");
			
			
			
			Hash<TNode<Integer>> hash = new Hash<>(10);
        
			for (int i = 0; i < tableHufman.size(); i++) {
				TNode<Integer> n1 = new TNode<>();
			if(tableHufman.get(i).getData()<0)
			{
				n1.setData(256+tableHufman.get(i).getData());
					
			}else {
				n1.setData((int)tableHufman.get(i).getData());
				
			}
				
				n1.setCode(tableHufman.get(i).getCode());
				n1.setFreq(tableHufman.get(i).getFrequncy());
				//System.out.println(n1.getData()+"    " + n1.getFreq() +"     "+n1.getCode());
			
				hash.insert(n1);
			}
			
			f2 = new FileInputStream(f1);
			n = 0;
			
			
			File fileout = new File(file.getPath()+"//"+file.getName()+".hfmn");
			FileOutputStream fos = new FileOutputStream(fileout);
			
			
			String length=file.getName();
			fos.write(length.length());
			byte[] chars=new byte[length.length()];
			heead =length.length()+"";
			
			for(int i=0;i<length.length();i++)
			{
				chars[i]=(byte)length.charAt(i);
				heead+=(char)chars[i];
			}
			heead+="\n";
			
			
			fos.write(chars);
			
			
			
			ArrayList<Byte> tree=preTraverc(root, new ArrayList<Byte>());
//			for(int i=0;i<tree.size();i++)
//			{
//				System.out.print(tree.get(i)+" ");
//			}
			byte[] orangenal=new byte[16];
			byte bits=0;
			int bytes=0;
			int count=0;
		
			for(int i=0;i<tree.size();i++)
			{
				if(tree.get(i)==0)
				{
					
						heead+=0;
					
					orangenal[bytes]=(byte) (orangenal[bytes]| (tree.get(i)) << 7 - bits);
					bits++;
					if (bits % 8 == 0) {
					 count++;
						bytes++;
						bits = 0;
					}
					if (bytes == 16) {
		              count=-1;
						bytes = 0;
						fos.write(orangenal);
						
						
						orangenal=new byte[16];
					}	
				}
				else if(tree.get(i)==1){
					heead+=1;
					
					orangenal[bytes]=(byte) (orangenal[bytes]| (tree.get(i)) << 7 - bits);
					bits++;
					if (bits % 8 == 0) {
					 count++;
					 //System.out.println(orangenal[bytes]);
					bytes++;
						bits = 0;
					}
					if (bytes == 16) {
		              count=-1;
		              
						bytes = 0;
						fos.write(orangenal);
						
						orangenal=new byte[16];
					}
					
					i++;
					int number=tree.get(i);
					
					
					
					
					
					if(number<0)
						number=256+number;
					//to make this binary
					String head="";
					//System.out.println(number+" oo");
					int tibites=0;
					while (tibites<8) {
						
						if(number>0)
						{
							head+=number%2;
							number=number/2;
						}else {
							head+="0";
						}
						tibites++;	
					}
					StringBuilder heade=new StringBuilder(head);
					heade.reverse();
					head=heade.toString();
				
					heead+=head;
				
					for(int j=0;j<head.length();j++)
					{
						
						orangenal[bytes]=(byte) (orangenal[bytes]| (Integer.parseInt(head.charAt(j)+"")) << 7 - bits);
						
						bits++;
						if (bits % 8 == 0) {
						 count++;
						// System.out.println(orangenal[bytes]);
							
							bytes++;
							bits = 0;
						}
						if (bytes == 16) {
			              count=-1;
							bytes = 0;
							
							fos.write(orangenal);
							orangenal=new byte[16];
						}
						
						
					}
				}
				
			}
//			System.out.println();
//			System.out.println(8-bits);
			if (count >= 0) {
				for(int i=0;i<=bytes;i++)
				{
					
					//System.out.print(orangenal[i]+"    ");
					
					fos.write(orangenal[i]);
				}
					
			}
			System.out.println(heead);
			fos.write((byte)8-bits);
			System.out.println();
		
			
			
			byte b[]= {(int)'e',(int)'n',(int)'d',(int)' ',(int)'l',(int)'i',(int)'n',(int)'e'};
			fos.write(b);
			for(int i=0;i<b.length;i++)
			{
				heead +=(char)b[i];
			}
			
			System.out.println(heead);
			 counter = 0;
			 buffer = new byte[16];
			 bits = 0;
			 bytes = 0;
			 count=-1;
			boolean on=false;
			while ((n = f2.read(buffer)) != -1) {
			
				//System.out.println(counter);
				//System.out.println(n+" number");
				for (int i = 0; i < n; i++) {
					
					int unsignedByte = buffer[i] & 0xFF;
					TNode<Integer> n1 = new TNode<>(unsignedByte);
					
					TNode<Integer> n2 = hash.search(n1);
					
					String code = n2.getCode();
					 for (int j = 0; j < code.length(); j++) {
                    	  on=true;
						Bufferout[bytes] = (byte) (Bufferout[bytes]| (Integer.parseInt(code.charAt(j) + "") << 7 - bits));
					
						bits++;
						if (bits % 8 == 0) {
						 count++;
							bytes++;
							bits = 0;
						}
						if (bytes == 16) {
							on=false;
                          count=-1;
                      	counter++;
							fos.write(Bufferout);
							bytes = 0;
							Bufferout = new byte[16];
						}
					}
                   
				}
			}
			if (on) {
				for(int i=0;i<=bytes;i++)
				{
					fos.write(Bufferout[i]);
				}
					
			}
			
			
			fos.write((byte)bits);
			
			
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("kkkkkkkkkkkkkkkkkkkkk");
		}
	
		
	
		
	}

	
	
	public static ArrayList<Byte> preTraverc(TNode<Integer> root, ArrayList<Byte> n) {

		 if (root != null) {
		        if (root.getLeft() == null && root.getRigth() == null) {
		        	n.add((byte)1);
		        	if(root.getData()>127)
		        		root.setData(root.getData()-256);
		        	
		        	
		        	n.add(root.getData().byteValue());
		        } else {
		        	n.add((byte)0);;
		        }
		        
		       preTraverc(root.getLeft(), n);       
		        preTraverc(root.getRigth(), n);
		    
		 }
		    return n;

	}

	
	
	
	
	

	public static void tran(TNode<Integer> newn, String n) {
		if (newn == null) {
			return;
		}

		if (newn.getLeft() != null) {
			tran(newn.getLeft(), n + "0");
		}
		if (newn.isleaf()) {
			
			TableHufman table=new TableHufman();
			table.setCode(n);
			table.setFrequncy(newn.getFreq());
			if(newn.getData()>127)
			{
				byte u=(byte) ((byte)(newn.getData()-256));
				table.setData(u);
	
			}
			else {
				
				byte u=(byte) ((byte)0+newn.getData());
				table.setData(u);
					
			}
			
			table.setLength((byte)n.length());
			
			tableHufman.add(table);
			counter++;
		}
		if (newn.getRigth() != null) {
			tran(newn.getRigth(), n + "1");
		}
	}
	
}

