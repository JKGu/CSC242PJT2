package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Domain {
	
	protected ArrayList<Object> values;
	
	public Domain() {
		this.values=new ArrayList<Object>();
	}
	
	public Domain(ArrayList<Object> values) {
		this.values=values;
	}
    public Domain(Object[] values) {
        this.values = new ArrayList<Object>();
        for (int i = 0; i < values.length; i++)
            this.values.add(values[i]);
    }
	
	public static Domain rgbDomain() {
		return new Domain(new String[] {"RED", "GREEN", "BLUE"});
	}
	
	public static Domain jssDomain() {
		return new Domain(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27});
	}
	
	public static Domain nqDomain(int n) {
		Domain temp=new Domain();
		for(Integer i = 0; i < n; i++) {
			for(Integer j = 0; j < n; j++) {
				ArrayList<Integer> array =new ArrayList<Integer>(); array.add(i);array.add(j);
				temp.values.add(array);
			}
		}
		return temp;
	}
	
	public ArrayList<Object> getDomain() {
		return this.values;
	}
	
	@Override
	public String toString() {
		return values.toString();
	}
}
