package aus;

import java.util.Date;
import java.util.HashSet;

import core.Assignment;
import core.CSP;
import core.Domain;
import core.Solver;
import core.Variable;

public class NQueenCSP extends core.CSP {
	
	public NQueenCSP(int n) {
		this.variables = new HashSet<core.Variable>();
		
		for(Integer nOfQ = 1; nOfQ <=n; nOfQ++) {
			Variable queen = new Variable("Queen "+nOfQ.toString(), Domain.nqDomain(n));
			this.variables.add(queen);
		}
		this.constraints = new HashSet<core.Constraint>();
		for(Variable queen1 : this.variables) {
			for(Variable queen2 : this.variables) {
				if(!queen1.toString().equals(queen2.toString())) { //if two queens are not the same, add them to the constraint.
					NotAttackingConstraint c = new NotAttackingConstraint(queen1, queen2);
					if(!this.constraints.contains(c)) { //if the constraint doesn't exit
						this.constraints.add(c);
					}
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {

		System.out.println("Job-shop scheduling problem (AIMA 6.1.2)");
		CSP csp = new NQueenCSP(8);
		System.out.println(csp);
		System.out.println("Backtracking search solver");
		Solver solver = new solver.BacktrackingSearchSolver();
		long start = new Date().getTime();
		Assignment result = solver.solve(csp);
		long end = new Date().getTime();
		System.out.format("time: %.3f secs\n", (end-start)/1000.0);
		System.out.println("result=" + result);
	}

}
