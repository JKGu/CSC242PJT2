package core;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Assignment {
	protected List<Variable> variables;
	protected Hashtable<Variable, Object> valueMap;
	protected boolean isFailure;
	
	public Assignment() {
		variables = new ArrayList<Variable>();
		valueMap=new Hashtable<Variable,Object>();
		isFailure=false;
	}
	
	public Assignment(boolean x) {
		super();this.isFailure=true;
	}
	public static final Assignment Failure =new Assignment(true);
	
	public void setVariables(CSP csp) {
		for(Variable v:csp.variables) {
			this.variables.add(v);
		}
	}
	
	public Object getValue(Variable v) {
		return valueMap.get(v);
	}
	
	public void addAssignment(Variable v, Object value) {
		valueMap.put(v, value);
	}
	
	public boolean isComplete() {

		for(Variable v: variables) {
			if(valueMap.containsKey(v)) {
				if(valueMap.get(v)==null) {
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
	}
	
	public Variable selectUnassignedVariable() {
		for(int i=0; i<variables.size();i++) {
			if(!valueMap.containsKey(variables.get(i))){
				return variables.get(i);
			}
		}
		return null;
	}

	public boolean isFailure() {
		return this.isFailure;
	}
	
	public String toString() {
		if(this.isFailure) return "FAILURE";
		return valueMap.toString();
	}
	
	public void remove(Object key, Object value) {
		this.valueMap.remove(key, value);
	}
}
