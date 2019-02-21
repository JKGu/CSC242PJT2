package core;

import java.util.HashSet;
import java.util.List;

public abstract class CSP {
	protected HashSet<core.Variable> variables;
	protected HashSet<core.Constraint> constraints;
	
	public List<Constraint> getConstraints(){
		return null;
	}
	public IDONTKNOW getVariables() {
		return null;
	}
}
