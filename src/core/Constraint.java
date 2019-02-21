package core;
import java.util.List;


public interface Constraint {
	    /**
	     * Returns a tuple of variables that participate in the constraint.
	     */
	    List<Variable> getScope();

	    /**
	     * Constrains the values that the variables can take on.
	     */
	    boolean isSatisfiedWith(Assignment assignment);
	}

