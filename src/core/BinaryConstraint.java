package core;

import java.util.List;

public abstract class BinaryConstraint implements Constraint{
	
	protected Variable v1;
	protected Variable v2;
	
	public BinaryConstraint(Variable v1, Variable v2) {
		this.v1=v1;
		this.v2=v2;
	}
	
	@Override
	public List<Variable> getScope() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
