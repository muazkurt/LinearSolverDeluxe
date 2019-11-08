package inc.solutions.numerical;

public class Matrix_Inversion_Behavior implements Matrix_Solve_Behavior
{
	public Matrix_Inversion_Behavior()
	{}

	@Override
	public double[] solve(double[][] input, double[] result)
	{
		double[]    return_val    = new double[result.length];
		double[][]  local_inverse = inverse(input);
		for (int i = 0; i < local_inverse.length; i++) {
			for (int j = 0; j < local_inverse[i].length; j++) {
				return_val[i] += local_inverse[i][j] * result[j];
			}
		}
		return return_val;
	}

	private double[][] minor(double[][] matrix, int row, int column)
	{
		double[][] minor = new double[matrix.length - 1][matrix.length - 1];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; i != row && j < matrix[i].length; j++)
				if (j != column)
					minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
		return minor;
	}

	private double determinant(double[][] matrix)
	{
		if (matrix.length != matrix[0].length)
			throw new IllegalStateException("invalid dimensions");
		double det = 0;

		if(matrix.length == 1)
			det = matrix[0][0];

		else if (matrix.length == 2)
			det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		else
			for (int i = 0; i < matrix[0].length; i++)
				det += Math.pow(-1, i) * matrix[0][i]
					       * determinant(minor(matrix, 0, i));
		return det;
	}

	private double[][] inverse(double[][] matrix)
	{
		double[][] inverse = new double[matrix.length][matrix.length];

		// minors and cofactors
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				inverse[i][j] = Math.pow(-1, i + j)
						                * determinant(minor(matrix, i, j));

		// adjugate and determinant
		double det = 1.0 / determinant(matrix);
		for (int i = 0; i < inverse.length; i++) {
			for (int j = 0; j <= i; j++) {
				double temp = inverse[i][j];
				inverse[i][j] = inverse[j][i] * det;
				inverse[j][i] = temp * det;
			}
		}

		return inverse;
	}
}
