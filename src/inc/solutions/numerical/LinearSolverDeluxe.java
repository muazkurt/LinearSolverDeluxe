package inc.solutions.numerical;

/**
 * This is a the main class that solves matrix equations.
 * For now only solves equations with given Behavior. Maybe in future, the class could differentiate a matrix.
 * @author Muaz Kurt
 * @version 1.0.0
 */
public class LinearSolverDeluxe {
    /**
     * This part is the solver part of the system.
     */
    private Solver solver;

    /**
     * Creates the class with given solving behavior.
     * @param behavior will be the behavior of the solver part of this class.
     */
    public LinearSolverDeluxe(Matrix_Solve_Behavior behavior)
    {
        solver = new Solver();
        solver.set_behavior(behavior);
    }

    /**
     * This method gives an opportunity to chance matrix solving behavior dynamically.
     * @param next_behavior is the next solving behavior.
     */
    public void change_solving_method(Matrix_Solve_Behavior next_behavior)
    {
        solver.set_behavior(next_behavior);
    }

    /**
     * Takes a 2d input matrix and 1d result matrix and solve the linear system of equations.
     * Then returns the result matrix
     * @param input MxM equation matrix to solve.
     * @param result M sized result matrix to solve.
     * @return Result vector of the linear system of equations.
     */
    public double[] solve(double[][] input, double[] result)
    {
        return solver.solve(input, result);
    }

}
