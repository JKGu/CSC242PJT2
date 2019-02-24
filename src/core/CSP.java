package core;

import java.util.HashSet;

public class CSP {
	protected HashSet<core.Variable> variables;
	protected HashSet<core.Constraint> constraints;
	
	public boolean isConsistent(Object value, Assignment a) {
		for(core.Constraint c :constraints) {
			if(!c.isSatisfiedWith(a))return false;
		}
		return true;
	}
	
	public String toString() {
		String output=new String();
		output+="\tVariables:	"+variables.toString()+"\n\tDomain:		";
		for(Variable v: variables) {
			output+=v.domain.toString(); break;
		}
		output+="\n\tConstraints:	"+this.constraints.toString();
		return output;
	}
}
