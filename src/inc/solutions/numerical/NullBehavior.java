package inc.solutions.numerical;

public class NullBehavior implements Matrix_Solve_Behavior
{
	@Override
	public double[] solve(double[][] input, double[] result)
	{
		System.err.println("Null behavior doesn't calculate anything. Please give a behavior.");
		return new double[0];
	}
}
