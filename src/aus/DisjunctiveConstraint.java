package aus;

import java.util.List;

import core.Assignment;
import core.BinaryConstraint;
import core.Constraint;
import core.Variable;

public class DisjunctiveConstraint extends BinaryCompoundConstraint {

	public DisjunctiveConstraint( Constraint lhs, Constraint rhs) {
		super("OR", lhs ,rhs );
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public List<Variable> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
