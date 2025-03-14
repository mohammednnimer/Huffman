package Algorethem2;

import java.lang.reflect.Array;

public class Min_Heab<T extends Comparable<T>> {
	private TNode<T>[] heab;
	private int n=0;
	public TNode<T>[] getHeab() {
		return heab;
	}
	public void setHeab(TNode<T>[] heab) {
		this.heab = heab;
	}
	
	public void traverce() {
	
		for(int i=1;i<=n;i++)
		{
			System.out.print(heab[i].toString()+"  ");
		}
	}
	public  boolean isheab(T [] array )
	{
		int n=array.length/2;
		while (n>0) {			
			if(n*2>=array.length&&(n*2)+1>=array.length)
			{
				
			}
			else if((n*2)+1>=array.length){
				
				if(array[n].compareTo(array[(n*2)])<0)
				{
					return false;
						
				}
			}
			else if(array[n].compareTo( array[(n*2)+1])<0||array[n].compareTo(array[(n*2)])<0)
			{
				return false;		
			}
			n--;
		}
	return true;
	}

	
	public void heapfy(T[] array)
	{
		
		
		int n=array.length/2;
		
		while (n>0) {
			sink(array,n,array.length-1);
			n--;
		}
	}
	
	
	


public void sort(T[] a)
{
	int n=a.length-1;
	for(int k=n/2;k>=1;k--)
	sink(a,k,n);
	while (n>1) {
		exch(a, 1,n--);
		sink(a, 1, n);
	}
	
	
	
	
}

	
	
       private boolean less(T[]a,int n,int m)
       {
	return a[n].compareTo(a[m])<0;		
        }

	public void sink(T[]a,int k,int n)
	{
		while (2*k<=n) {
			int j=2*k;
			if(j<n&&less(a,j,j+1))	
				j++;
			if(!less(a,k, j))
				break;
			exch(a,k, j);
			k=j;
			
		}
		
		
		
		
		
	}
	
	
	public Min_Heab(int c)
	{
		heab= new TNode[c+1];
		
	}
	
	public void Swim(int k)
	{
		while (k>1&&less(k,k/2)) {
			exch(k/2,k);
			k=k/2;
		}
	}
	private boolean less(int n,int m)
	{
		return heab[n].compareTo(heab[m])<0;		
	}
	private void exch(int n,int m)
	{
		TNode<T> temp=heab[n];
		heab[n]=heab[m];
		heab[m]=temp;
	}
	
	private void exch(T[]a,int n,int m)
	{
		T temp=a[n];
		a[n]=a[m];
		a[m]=temp;
	}
	
	public void insert(TNode<T> data)
	{
	
		if(n+1==heab.length)
		{
			resc();	
		}
		
		heab[++n]=data;
		Swim(n);	
		
	}
	
	public void resc()
	{
		
		TNode<T>[] temp= new TNode[heab.length*2];
		
		for(int i=0;i<heab.length;i++)
		{
			
			temp[i]=heab[i];
			
		}
		
		heab=temp;
		
	}
	
	
	
	public boolean isEmpty()
	{
		return n==0;
	}
	public TNode<T> deletMin()
	{
	if(isEmpty())
		return null;
	TNode<T> max=heab[1];
	exch(1, n--);
	sink(1);	
		heab[n+1]=null;
		try {
			return max;
		}catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	
	}
	private void sink(int k)
	{
		while (2*k<=n) {
			int j=2*k;
			if(j<n&&less(j+1,j))	
				j++;
			if(less(k, j))
				break;
			exch(k, j);
			k=j;
			
		}
	}
	
	
	
}
