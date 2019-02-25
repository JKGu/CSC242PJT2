package aus;

import java.util.List;

import core.Assignment;
import core.BinaryConstraint;
import core.Constraint;
import core.Variable;

public class PrecedenceConstraint extends BinaryConstraint  {
	int d;
	
	public PrecedenceConstraint(Variable v1, Variable v2, int d) {
		super(v1,v2);
		this.d=d;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSatisfiedWith(Assignment assignment) {
		Object v1=assignment.getValue(this.v1);
		Object v2=assignment.getValue(this.v2);
		
		if (v1==null||v2==null) {
			return true;
		}else {
		int vaa1 = Integer.parseInt(v1.toString());
		
		int vaa2 = Integer.parseInt(v2.toString());
		
		return !((vaa1+d)<=vaa2);
		}
	}

	@Override
	public String toString() {
		return v1.toString()+ " + " + d + " <= " + v2.toString();
		
	}

	@Override
	public List<Variable> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
