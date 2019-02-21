package core;

import java.util.Iterator;
import java.util.List;

public class Domain implements Iterable<Object> {
	protected Object[] values;
	
	public Domain(List<?> values) {
		this.values=new Object[values.size()];
		for(int i=0; i<values.size(); i++) {
			this.values[i]=values.get(i);
		}
	}
    public Domain(Object[] values) {
        this.values = new Object[values.length];
        for (int i = 0; i < values.length; i++)
            this.values[i] = values[i];
    }

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Domain rgbDomain() {
		String r="RED"; String g="GREEN"; String b="BLUE";
		return new Domain(new Object[] {r, g, b});
	}
}
