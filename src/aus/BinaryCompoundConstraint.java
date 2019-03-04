package aus;

import java.util.ArrayList;
import java.util.List;

import core.Assignment;
import core.Constraint;
import core.Variable;

public class BinaryCompoundConstraint implements Constraint {
    
	protected String connective;
	protected Constraint lhs;
	protected Constraint rhs;
	protected List<Variable> scope;
	
	BinaryCompoundConstraint(String connective, Constraint lhs, Constraint rhs){
		this.connective=connective;
		this.lhs=lhs;
		this.rhs=rhs;
		this.scope=new ArrayList<Variable>();
		this.scope.addAll(lhs.getScope());
		this.scope.addAll(rhs.getScope());
	}
	
	@Override
	public List<Variable> getScope() {
		return this.scope;
	}
	

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		switch(connective) {
		case "OR":
		return lhs.isSatisfiedWith(assignment)||rhs.isSatisfiedWith(assignment);
		case "AND":
		return lhs.isSatisfiedWith(assignment) && rhs.isSatisfiedWith(assignment);
		}
		return false;
	}

	@Override
	public String toString() {
		return lhs.toString()+ " "+ connective + " " +rhs.toString() ;
	}

}
