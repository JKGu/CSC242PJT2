package aus;

import java.util.List;

import core.Assignment;
import core.Constraint;
import core.Variable;

public class BinaryCompoundConstraint implements Constraint {
    
	protected String connective;
	protected Constraint lhs;
	protected Constraint rhs;
	
	BinaryCompoundConstraint(String connective, Constraint lhs, Constraint rhs){
		this.connective=connective;
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	@Override
	public List<Variable> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		// TODO Auto-generated method stub
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
