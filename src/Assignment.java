
public class Assignment {
	/**
     * Contains all assigned variables. Positions reflect the order in which
     * the variables were assigned to values.
     */
    List<Variable> variables;
    /**
     * Maps variables to their assigned values.
     */
    Hashtable<Variable, Object> variableToValue;

    public Assignment() {
        variables = new ArrayList<Variable>();
        variableToValue = new Hashtable<Variable, Object>();
    }

//    public List<Variable> getVariables() {
//        return Collections.unmodifiableList(variables);
//    }

    public Object getAssignment(Variable var) {
        return variableToValue.get(var);
    }

    public void setAssignment(Variable var, Object value) {
        if (!variableToValue.containsKey(var))
            variables.add(var);
        variableToValue.put(var, value);
    }

    public void removeAssignment(Variable var) {
        if (hasAssignmentFor(var)) {
            variables.remove(var);
            variableToValue.remove(var);
        }
    }

    public boolean hasAssignmentFor(Variable var) {
        return variableToValue.get(var) != null;
    }

    /**
     * Returns true if this assignment does not violate any constraints of
     * <code>constraints</code>.
     */
    public boolean isConsistent(List<Constraint> constraints) {
        for (Constraint cons : constraints)
            if (!cons.isSatisfiedWith(this))
                return false;
        return true;
    }

    /**
     * Returns true if this assignment assigns values to every variable of
     * <code>vars</code>.
     */
    public boolean isComplete(List<Variable> vars) {
        for (Variable var : vars) {
            if (!hasAssignmentFor(var))
                return false;
        }
        return true;
    }

    /**
     * Returns true if this assignment assigns values to every variable of
     * <code>vars</code>.
     */
    public boolean isComplete(Variable[] vars) {
        for (Variable var : vars) {
            if (!hasAssignmentFor(var))
                return false;
        }
        return true;
    }

    /**
     * Returns true if this assignment is consistent as well as complete with
     * respect to the given CSP.
     */
    public boolean isSolution(CSP csp) {
        return isConsistent(csp.getConstraints())
                && isComplete(csp.getVariables());
    }

    public Assignment copy() {
        Assignment copy = new Assignment();
        for (Variable var : variables) {
            copy.setAssignment(var, variableToValue.get(var));
        }
        return copy;
    }

  
}
