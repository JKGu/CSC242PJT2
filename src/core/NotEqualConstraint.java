package core;

import java.util.List;

public class NotEqualConstraint extends BinaryConstraint {
	
	public NotEqualConstraint(Variable v1, Variable v2) {
		super(v1, v2);
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		Object v1=assignment.getValue(this.v1);
		Object v2=assignment.getValue(this.v2);
		return v1==null||!v1.equals(v2);
	}
	
	@Override
	public String toString() {
		return super.v1.toString()+"!="+super.v2.toString();
	}
}
