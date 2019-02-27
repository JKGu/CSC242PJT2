package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class BinaryConstraint implements Constraint{
	
	protected Variable v1;
	protected Variable v2;
	protected List<Variable> scope;
	
	public BinaryConstraint(Variable v1, Variable v2) {
		this.v1=v1;
		this.v2=v2;
		this.scope=new ArrayList<Variable>();
		this.scope.add(v1);
		this.scope.add(v2);
	}
	
	@Override
	public List<Variable> getScope() {
		return this.scope;
	}
	
}
