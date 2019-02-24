package solver;

import java.util.ArrayList;

import core.*;

public class BacktrackingSearchSolver extends Solver{
	
	//AIMA pseudo-code:
	/*
	function BACKTRACKING-SEARCH(csp) returns a solution, or failure
	return BACKTRACK({ }, csp)
	*/
    
	@Override
	public Assignment solve(CSP csp) {
		Assignment a=new Assignment();
		a.setVariables(csp);
		return backtrack(a, csp);
	}
	
	/*
	function BACKTRACK(assignment, csp) returns a solution, or failure
	if assignment is complete then return assignment
	var ¡û SELECT-UNASSIGNED-VARIABLE(csp)
	for each value in ORDER-DOMAIN-VALUES(var, assignment, csp) do
	if value is consistent with assignment then
	add {var = value} to assignment
	result =  backtrack(assignment, csp)
	if result = failure then
	return result
	remove {var = value} and inferences from assignment
	return failure
	*/
	
	public Assignment backtrack(Assignment a, CSP csp) {
		if(a.isComplete()) {
			return a;
		}
		Variable var= a.selectUnassignedVariable();
		Object[] tmp = var.orderDomainValue().toArray(); 
		for(int i=0; i<tmp.length;i++) {
			if(csp.isConsistent(tmp[i], a)) {
				a.addAssignment(var, tmp[i]);
				Assignment result=backtrack(a,csp);
				if(!result.isFailure()) return result;
				else a.remove(var, tmp[i]);
			}
		}
		return new Assignment().Failure;
	}
}
