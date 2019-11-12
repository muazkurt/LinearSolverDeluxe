package inc.solutions.numerical;

/**
 * This is an interface that contain only ona method to declare the matrix solving behavior of
 * each possible mathematical method. After implementing this method, any subclass can be used in the
 * LinearSolverDeluxe system.
 * @author Muaz Kurt
 * @version 1.0.0
 */
public interface Matrix_Solve_Behavior
{
    /**
     * Takes a 2d input matrix and 1d result matrix and solve the linear system of equations.
     * Then returns the result matrix
     *
     * @param input  MxM equation matrix to solve.
     * @param result M sized result matrix to solve.
     * @return Result vector of the linear system of equations.
     */
    double[] solve(double[][] input, double[] result);
}
