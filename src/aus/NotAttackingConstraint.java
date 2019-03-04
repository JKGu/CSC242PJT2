package aus;

import java.util.ArrayList;

import core.Assignment;
import core.BinaryConstraint;
import core.Variable;

public class NotAttackingConstraint extends BinaryConstraint{

	public NotAttackingConstraint(Variable v1, Variable v2) {
		super(v1, v2);
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		if(assignment.getValue(super.v1)==null||assignment.getValue(super.v2)==null)return true;
		ArrayList<Integer> assignmentV1 = (ArrayList<Integer>) assignment.getValue(super.v1);
		ArrayList<Integer> assignmentV2 = (ArrayList<Integer>) assignment.getValue(super.v2);
		Integer x1 = assignmentV1.get(0);
		Integer y1 = assignmentV1.get(1);
		Integer x2 = assignmentV2.get(0);
		Integer y2 = assignmentV2.get(1);
		
		if(x1 != x2 && y1 != y2 && (x1-y1) != (x2-y2) && (x1+y1) != (x2+y2)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return super.v1.toString()+"!="+super.v2.toString();
	}

}
