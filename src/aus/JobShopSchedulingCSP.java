package aus;

import java.util.Date;
import java.util.HashSet;

import core.*;

//AIMA 6.1.2 
/*require variables whose domains are integers
 * model each task as a variable, where the value of each variable is the time that the task starts
 * expressed as an integer number of minutes
 * constraint can be one task occur before another
 * constraint can also be a task takes a certain time to complete
 */
public class JobShopSchedulingCSP extends core.CSP {
	
	public JobShopSchedulingCSP() {
		this.variables = new HashSet<core.Variable>();
		Variable AxleF = new Variable("AxleF", Domain.jssDomain());
		this.variables.add(AxleF);
		Variable AxleB = new Variable("AxleB", Domain.jssDomain());
		this.variables.add(AxleB);
		Variable WheelRF = new Variable("WheelRF", Domain.jssDomain());
		this.variables.add(WheelRF);
		Variable WheelLF = new Variable("WheelLF", Domain.jssDomain());
		this.variables.add(WheelLF);
		Variable WheelRB = new Variable("WheelRB", Domain.jssDomain());
		this.variables.add(WheelRB);
		Variable WheelLB = new Variable("WheelLB", Domain.jssDomain());
		this.variables.add(WheelLB);
		Variable NutsRF = new Variable("NutsRF", Domain.jssDomain());
		this.variables.add(NutsRF);
		Variable NutsLF = new Variable("NutsLF", Domain.jssDomain());
		this.variables.add(NutsLF);
		Variable NutsRB = new Variable("NutsRB", Domain.jssDomain());
		this.variables.add(NutsRB);
		Variable NutsLB = new Variable("NutsLB", Domain.jssDomain());
		this.variables.add(NutsLB);
		Variable CapRF = new Variable("CapRF", Domain.jssDomain());
		this.variables.add(CapRF);
		Variable CapLF = new Variable("CapLF", Domain.jssDomain());
		this.variables.add(CapLF);
		Variable CapRB = new Variable("CapRB", Domain.jssDomain());
		this.variables.add(CapRB);
		Variable CapLB = new Variable("CapLB", Domain.jssDomain());
		this.variables.add(CapLB);
		Variable Inspect = new Variable("Inspect", Domain.jssDomain());
		this.variables.add(Inspect);
		
		this.constraints = new HashSet<core.Constraint>();
		this.constraints.add(new PrecedenceConstraint(AxleF, WheelRF,10));
		this.constraints.add(new PrecedenceConstraint(AxleF, WheelLF,10));
		this.constraints.add(new PrecedenceConstraint(AxleB, WheelRB,10));
		this.constraints.add(new PrecedenceConstraint(AxleB, WheelLB,10));
		this.constraints.add(new PrecedenceConstraint(AxleF,AxleB,10));//
		this.constraints.add(new PrecedenceConstraint(AxleB, AxleF,10));//
		this.constraints.add(new PrecedenceConstraint(WheelRF, NutsRF,1));
		this.constraints.add(new PrecedenceConstraint(WheelLF, NutsLF,1));
		this.constraints.add(new PrecedenceConstraint(WheelRB, NutsRB,1));
		this.constraints.add(new PrecedenceConstraint(WheelLB, NutsLB,1));
		this.constraints.add(new PrecedenceConstraint(NutsRF, CapRF,2));
		this.constraints.add(new PrecedenceConstraint(NutsLF, CapLF,2));
		this.constraints.add(new PrecedenceConstraint(NutsRB, CapRB,2));
		this.constraints.add(new PrecedenceConstraint(NutsLB, CapLB,2));
		this.constraints.add(new DisjunctiveConstraint(new PrecedenceConstraint(AxleF,AxleB,10), new PrecedenceConstraint(AxleB, AxleF,10)));
		//Inspection must be finished after the hubcaps are done
		this.constraints.add(new InspectionConstraint(CapRF,Inspect));
		this.constraints.add(new InspectionConstraint(CapLF,Inspect));
		this.constraints.add(new InspectionConstraint(CapRB,Inspect));
		this.constraints.add(new InspectionConstraint(CapLB,Inspect));
	}

	
	public static void main(String[] args) {

		System.out.println("Job-shop scheduling problem (AIMA 6.1.2)");
		CSP csp = new JobShopSchedulingCSP();
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
