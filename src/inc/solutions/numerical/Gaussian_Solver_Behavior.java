package inc.solutions.numerical;

/**
 * This class implements Matrix Solve Behavior to create a behavior thar solves an matrix equation
 * with Gaussian Elimination.
 * @author Muaz Kurt
 * @version 1.0.0
 * @see inc.solutions.numerical.Matrix_Solve_Behavior
 */
public class Gaussian_Solver_Behavior implements Matrix_Solve_Behavior
{
    private static final double EPSILON = 1e-10;

    /**
     * Gaussian Elimination method for finding elements of the given matrix.
     * @param input MzM sized matrix that contains equations.
     * @param result M sized matrix that contains result of input equations.
     * @return M sized x elements that makes the equations possible.
     */
    private double[] gaussian(double[][] input, double[] result)
    {
        int n = result.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(input[i][p]) > Math.abs(input[max][p])) {
                    max = i;
                }
            }
            double[] temp = input[p];
            input[p] = input[max];
            input[max] = temp;
            double t = result[p];
            result[p] = result[max];
            result[max] = t;
            // singular or nearly singular
            if (Math.abs(input[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within input and result
            for (int i = p + 1; i < n; i++) {
                double alpha = input[i][p] / input[p][p];
                result[i] -= alpha * result[p];
                for (int j = p; j < n; j++) {
                    input[i][j] -= alpha * input[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += input[i][j] * x[j];
            }
            x[i] = (result[i] - sum) / input[i][i];
        }
        return x;
    }

    @Override
    public double[] solve(double[][] input, double[] result)
    {
        return gaussian(input, result);
    }
}
