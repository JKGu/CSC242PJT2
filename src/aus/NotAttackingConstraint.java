package aus;

import core.Assignment;
import core.BinaryConstraint;
import core.Variable;

public class NotAttackingConstraint extends BinaryConstraint{

	public NotAttackingConstraint(Variable v1, Variable v2) {
		super(v1, v2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		// TODO Auto-generated method stub
		return false;
	}

}
