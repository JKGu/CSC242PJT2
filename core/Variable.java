package core;

import java.util.ArrayList;

public class Variable {
	protected String name;
	protected Domain domain;
	
	public Variable (String name, Domain domain) {
		this.name=name;
		this.domain=domain;
	}
	
	public ArrayList<Object> orderDomainValue() {
		return this.domain.values;
	}
	
	public String toString() {
		return name;
	}
}
