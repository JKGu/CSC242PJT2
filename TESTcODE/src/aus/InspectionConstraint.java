package aus;

import core.Assignment;
import core.BinaryConstraint;
import core.Variable;

public class InspectionConstraint extends BinaryConstraint {

	public InspectionConstraint(Variable v1, Variable v2) {
		super(v1, v2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		// TODO Auto-generated method stub
		Object v1=assignment.getValue(this.v1);
		Object v2=assignment.getValue(this.v2);
		if (v1==null||v2==null) {
			return true;
		}

		int vaa1 = Integer.parseInt(v1.toString());
		
		int vaa2 = Integer.parseInt(v2.toString());
		return (vaa1<vaa2);
		
	}
	
	@Override
	public String toString() {
		return v1.toString() + " < " + v2.toString();
		
	}

}
