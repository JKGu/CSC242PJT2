package core;

public class BacktrackingSolver extends Solver{
	//AIMA pseudo-code:
	/*
	function BACKTRACKING-SEARCH(csp) returns a solution, or failure
	return BACKTRACK({ }, csp)
	*/
	
	
	/*
	function BACKTRACK(assignment, csp) returns a solution, or failure
	if assignment is complete then return assignment
	var ¡û SELECT-UNASSIGNED-VARIABLE(csp)
	for each value in ORDER-DOMAIN-VALUES(var, assignment, csp) do
	if value is consistent with assignment then
	add {var = value} to assignment
	inferences ¡û INFERENCE(csp, var, value)
	if inferences = failure then
	add inferences to assignment
	result ¡û BACKTRACK(assignment, csp)
	if result = failure then
	return result
	remove {var = value} and inferences from assignment
	return failure
	*/
}
