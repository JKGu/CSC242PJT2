package core;

import java.util.HashSet;

public class CSP {
	protected HashSet<core.Variable> variables;
	protected HashSet<core.Constraint> constraints;
	
	public boolean isConsistent(Variable var, Assignment a, Object value) {

		HashSet<core.Constraint> tmp=this.constraints;
		if(var!=null) {
			tmp=getRelatedConstraints(var);
			}
		a.addAssignment(var, value);
		for(core.Constraint c :tmp) {
			if(!c.isSatisfiedWith(a)) {
				a.remove(var, value);
				return false;
			}
		}
		a.remove(var, value);
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
	
	public HashSet<core.Constraint> getRelatedConstraints(Variable var){
		HashSet<core.Constraint> output=new HashSet<core.Constraint>();
		for(core.Constraint c: this.constraints) {
			if(c.getScope().contains(var)) {
				output.add(c);
			}
		}

		return output;
	}
}
