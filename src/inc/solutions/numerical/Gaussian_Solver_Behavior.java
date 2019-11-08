package inc.solutions.numerical;

public class Gaussian_Solver_Behavior implements Matrix_Solve_Behavior
{
    public Gaussian_Solver_Behavior()
    {}

    private static final double EPSILON = 1e-10;

    // Gaussian elimination with partial pivoting
    @Override
    public double[] solve(double[][] input, double[] result)
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
            double[] temp = input[p]; input[p] = input[max]; input[max] = temp;
            double   t    = result[p]; result[p] = result[max]; result[max] = t;
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
}
